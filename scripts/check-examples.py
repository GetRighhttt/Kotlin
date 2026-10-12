#!/usr/bin/env python3
"""Compile the reference, check corrected behavior, and run each main function."""
import os
from pathlib import Path
import re
import shutil
import subprocess
import sys

ROOT = Path(__file__).resolve().parents[1]


def tool(name):
    executable = os.environ.get(name.upper()) or shutil.which(name)
    if not executable:
        raise RuntimeError(f"Install {name}, put it on PATH, or set {name.upper()} to its executable.")
    return executable


def run(command, input_text=None, timeout=15):
    result = subprocess.run(command, input=input_text, text=True, capture_output=True,
                            cwd=ROOT, timeout=timeout)
    if result.returncode:
        raise RuntimeError(f"Failed: {' '.join(map(str, command))}\n{result.stdout}{result.stderr}")
    return result.stdout


def main():
    compiler, runtime = tool("kotlinc"), tool("kotlin")
    version = subprocess.run([compiler, "-version"], text=True, capture_output=True, check=True)
    print((version.stdout + version.stderr).strip())
    build = ROOT / "build"
    build.mkdir(exist_ok=True)
    jar = build / "reference-checks.jar"
    run([compiler, str(ROOT / "src/main/kotlin"), str(ROOT / "src/test/kotlin"),
         "-Werror", "-d", str(jar)], timeout=120)
    print(run([runtime, "-classpath", str(jar), "ReferenceChecksKt"]), end="")

    inputs = {
        "basics.ReadingUserInputKt": "hello\n32\n",
        "datastructures.ListKt": "1\n2\n3\n4\n5\n",
        "advancedkotlin.functional.ExtensionFunctionsKt": "97\nStefan\n",
        "androidconcepts.BackingFieldKt": "5\n",
        "androidconcepts.BackingPropertyKt": "lion\ntiger\nbear\ngiraffe\ncow\n",
    }
    expected = {
        "basics.ReadingUserInputKt": ["olleh", "This is the number minus 10: 22"],
        "advancedkotlin.functional.ExtensionFunctionsKt": ["is a prime number", "******"],
        "advancedkotlin.functional.morefunctions.LocalFunctionsKt": ["Perimeter: 108.0"],
        "androidconcepts.BackingFieldKt": ["You are a baby!"],
        "androidconcepts.BackingPropertyKt": ["[Cat, Dog, Squirrel]"],
    }
    count = 0
    for source in sorted((ROOT / "src/main/kotlin").rglob("*.kt")):
        text = source.read_text()
        if not re.search(r"^fun main\(\)", text, re.MULTILINE):
            continue
        package = re.search(r"^package ([\w.]+)", text, re.MULTILINE).group(1)
        entry = f"{package}.{source.stem}Kt"
        output = run([runtime, "-classpath", str(jar), entry], inputs.get(entry, ""))
        for line in expected.get(entry, []):
            if line not in output.splitlines():
                raise RuntimeError(f"{entry}: missing expected output {line!r}\n{output}")
        count += 1

    # Each input reader must also terminate on EOF and malformed input.
    cases = [(entry, "", "") for entry in inputs]
    cases += [
        ("basics.ReadingUserInputKt", "hello\nwrong\n", "Please enter a whole number within the Int range."),
        ("basics.ReadingUserInputKt", "hello\n-2147483648\n", "This is the number minus 10: -2147483658"),
        ("datastructures.ListKt", "bad\n\n3\n1\n", "Input ended after 2 numbers."),
        ("advancedkotlin.functional.ExtensionFunctionsKt", "wrong\nStefan\n", "No valid Int was supplied."),
        ("advancedkotlin.functional.ExtensionFunctionsKt", "-7\nsam\n", "not prime"),
        ("androidconcepts.BackingFieldKt", "-1\n", "No valid age was supplied."),
        ("androidconcepts.BackingFieldKt", "wrong\n", "No valid age was supplied."),
        ("androidconcepts.BackingPropertyKt", "\n  Fox  \nq\n", "[Fox]"),
    ]
    for entry, input_text, expected_line in cases:
        output = run([runtime, "-classpath", str(jar), entry], input_text)
        if expected_line and expected_line not in output.splitlines():
            raise RuntimeError(f"{entry}: missing {expected_line!r}\n{output}")
    print(f"Compiled with warnings treated as errors; ran {count} examples and {len(cases)} input cases.")


if __name__ == "__main__":
    try:
        main()
    except (RuntimeError, subprocess.TimeoutExpired) as error:
        print(error, file=sys.stderr)
        sys.exit(1)

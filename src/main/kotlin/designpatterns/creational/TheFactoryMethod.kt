package designpatterns.creational

/*
The factory pattern is a creation design pattern that aims to create or build objects in a more proficient manner. This
design pattern, like singleton, is one of the core android design patterns that are pretty much already built into the
Kotlin language in most areas, however it is important to know how the factory pattern is created just in case we might
need to create this for our own use case in the future.

The factory pattern hides the complexity of creating and selecting the right object for the job.
Essentially, it works to create objects and hides the complexity of creating objects of the same family.
 */

interface FileParser

class XmlFileParser : FileParser
class JsonFileParser : FileParser

/* The concept of the factory -> creates a Product */
interface FileParserFactory {
    fun createFromFileName(fileName: String): FileParser
}

/*
Better option where we don't need to instantiate the object in main method anymore
 */
class CompanionObjectFileParserFactory : FileParserFactory {
    companion object : FileParserFactory{
        override fun createFromFileName(fileName: String) =
            when (fileName.substringAfterLast('.')) {
                "xml" -> XmlFileParser()
                "json" -> JsonFileParser()
                else -> throw Exception("I don't know how to deal with $fileName.")
            }
    }

    /* needed if you want to be able to call the createFromFileName from an instance */
    override fun createFromFileName(fileName: String) =
        CompanionObjectFileParserFactory.createFromFileName(fileName)
}



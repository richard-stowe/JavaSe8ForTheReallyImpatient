package io.scrumbox.java8.chapter1

import spock.lang.Shared
import spock.lang.Specification

import static java.nio.file.Files.createTempDirectory

class Chapter1FileTest extends Specification {

    @Shared
    def tempDirectory = new File(createTempDirectory("Temp").toUri())

    def setupSpec() {
        10.times {
            new File(tempDirectory, "Directory${it}").mkdir()
            new File(tempDirectory, "File${it}.txt") << "File${it} Text"
            new File(tempDirectory, "File${it}.md") << "File${it} Text"
        }
    }

    def cleanupSpec() {
        tempDirectory.deleteDir()
    }

    def "Get subdirectories"() {

        def subject = new Chapter1Exercise02()

        when:
        def result = subject.getSubdirectories(tempDirectory)

        then:
        result.size() == 10
        result.every { it.isDirectory() }

    }

    def "Get files by extension"() {

        def subject = new Chapter1Exercise03()

        given:
        def extension = ".txt"

        when:
        def result = subject.getByExtenstion(tempDirectory, extension)

        then:
        result.size() == 10
        result.every { it.name.endsWith(extension) }

    }

    def "Get files ordered by directory then path name"() {

        def subject = new Chapter1Exercise04()

        given:
        def files = tempDirectory.listFiles()

        when:
        subject.orderFiles(files)

        then:
        files[0..9].every {it.isDirectory()}
        files[10..29].collect {it.name} == files.findAll {it.isFile()}.collect {it.name}.sort()

    }

}

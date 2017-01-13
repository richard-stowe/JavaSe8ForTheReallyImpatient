package io.scrumbox.java8.chapter1

import spock.lang.Specification


class Chapter1Exercise1Test extends Specification {

    def subject = new Chapter1Exercise01()

    def "Arrays.sort sorts an array using a single thread"() {

        given:
        def fruits = ["Pear", "Apple", "Banana"] as String[]

        when:
        subject.sort(fruits)

        then:
        fruits == ["Apple", "Banana", "Pear"]

        and:
        subject.threadIds.size() == 1

    }

}

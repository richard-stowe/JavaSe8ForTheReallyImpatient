package io.scrumbox.java8.chapter1

import spock.lang.Specification


class Chapter1Exercise07Test extends Specification {

    def subject = new Chapter1Exercise07()

    def "action executes 3 Runnable instances in order"() {

        when:
        subject.action()

        then:
        subject.output == [
                "Runnable 1",
                "Runnable 2",
                "Runnable 3"
        ]

    }

}

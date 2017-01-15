package io.scrumbox.java8.chapter1

import io.scrumbox.java8.exception.MyCheckedException
import spock.lang.Specification


class Chapter1Exercise06Test extends Specification {

    def subject = new Chapter1Exercise06()

    def "action wraps a checked exception into a RuntimeException"() {

        when:
        subject.action()

        then:
        def exception = thrown(RuntimeException)
        exception.cause instanceof MyCheckedException

    }

}

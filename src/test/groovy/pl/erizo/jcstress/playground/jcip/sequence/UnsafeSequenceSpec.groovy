package pl.erizo.jcstress.playground.jcip.sequence

import pl.erizo.jcstress.playground.jcip.UnsafeSequence
import spock.lang.Specification

class UnsafeSequenceSpec extends Specification {

    def "should increment by one"(){
        given:
        def counter = new UnsafeSequence()

        when:
        counter.increment()

        then:
        counter.getX() == 1
    }
}

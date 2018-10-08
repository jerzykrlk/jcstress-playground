package pl.erizo.jcstress.playground.counter

import spock.lang.Specification

class MyLongCounterSpec extends Specification {

    def "should increment by one"(){
        given:
        def counter = new MyLongCounter()

        when:
        counter.increment()

        then:
        counter.getX() == 1
    }
}

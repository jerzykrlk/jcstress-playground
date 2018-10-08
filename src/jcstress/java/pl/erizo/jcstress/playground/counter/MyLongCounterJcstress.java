package pl.erizo.jcstress.playground.counter;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.L_Result;

@JCStressTest
@Outcome(id = "2", expect = Expect.ACCEPTABLE, desc = "Incremented twice")
@State
public class MyLongCounterJcstress {

    private MyLongCounter myLongCounter = new MyLongCounter();

    @Actor
    public void actor1() {
        myLongCounter.increment();
    }

    @Actor
    public void actor2() {
        myLongCounter.increment();
    }

    @Arbiter
    public void arbiter(L_Result result) {
        result.r1 = myLongCounter.getX();
    }
}

package pl.erizo.jcstress.playground.jcip.visibility;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = "42", expect = Expect.ACCEPTABLE, desc = "default output expected")
@State
public class NoVisibilityJcstress {

    private boolean ready;
    private int number;

    @Actor
    public void actor1() {
        number = 42;
        ready = true;
    }

    @Actor
    public void actor2(I_Result result) {
        while (!ready) {
            Thread.yield();
        }
        result.r1 = number;
    }

}

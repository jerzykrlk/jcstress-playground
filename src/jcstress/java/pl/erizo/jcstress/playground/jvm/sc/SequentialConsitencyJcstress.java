package pl.erizo.jcstress.playground.jvm.sc;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@State
@Outcome(id = "43", expect = Expect.ACCEPTABLE, desc = "see after ready set")
public class SequentialConsitencyJcstress {
    private int a = 0;
    private boolean ready = false;

    @Actor
    public void actor1() {
        a = 41;
        a = 42;
        ready = true;
        a = 43;
    }

    @Actor
    public void actor2(I_Result result) {
        while (!ready) {
        }
        result.r1 = a;
    }

}

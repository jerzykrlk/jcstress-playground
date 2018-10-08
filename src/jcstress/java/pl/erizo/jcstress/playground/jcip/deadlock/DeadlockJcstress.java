package pl.erizo.jcstress.playground.jcip.deadlock;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.LL_Result;
import org.openjdk.jcstress.infra.results.SS_Result;

@JCStressTest
@State
@Outcome(id = "true", expect = Expect.ACCEPTABLE, desc = "published completely or not yet published")
public class DeadlockJcstress {

    private final Object left = new Object();
    private final Object right = new Object();

    @Actor
    public void actor1(LL_Result result) {
        synchronized (left) {
            synchronized (right) {
                result.r1 = "actor1";
            }
        }
    }

    @Actor
    public void actor2(LL_Result result) {
        synchronized (right) {
            synchronized (left) {
                result.r1 = "actor2";
            }
        }
    }

}

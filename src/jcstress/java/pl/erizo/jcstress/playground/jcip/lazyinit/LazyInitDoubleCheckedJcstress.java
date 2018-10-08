package pl.erizo.jcstress.playground.jcip.lazyinit;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.Z_Result;

@JCStressTest
@State
@Outcome(id = "true", expect = Expect.ACCEPTABLE, desc = "both returned same instance")
public class LazyInitDoubleCheckedJcstress {

    private LazyInitDoubleCheckedRace lazyInitDoubleCheckedRace = new LazyInitDoubleCheckedRace();

    private LazyInitDoubleCheckedRace instance1;
    private LazyInitDoubleCheckedRace instance2;

    @Actor
    public void actor1() {
        instance1 = lazyInitDoubleCheckedRace.getInstance();
    }

    @Actor
    public void actor2() {
        instance2 = lazyInitDoubleCheckedRace.getInstance();
    }

    @Arbiter
    public void arbiter(Z_Result result) {
        result.r1 = (instance1 == instance2);
    }
}

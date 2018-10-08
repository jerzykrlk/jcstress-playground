package pl.erizo.jcstress.playground.jcip.lazyinit;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.Z_Result;

@JCStressTest
@State
@Outcome(id = "true", expect = Expect.ACCEPTABLE, desc = "both returned same instance")
public class LazyInitRaceJcstress {

    private LazyInitRace lazyInitRace = new LazyInitRace();

    private LazyInitRace instance1;
    private LazyInitRace instance2;

    @Actor
    public void actor1() {
        instance1 = lazyInitRace.getInstance();
    }

    @Actor
    public void actor2() {
        instance2 = lazyInitRace.getInstance();
    }

    @Arbiter
    public void arbiter(Z_Result result) {
        result.r1 = (instance1 == instance2);
    }
}

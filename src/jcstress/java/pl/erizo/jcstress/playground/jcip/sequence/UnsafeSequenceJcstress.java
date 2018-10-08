package pl.erizo.jcstress.playground.jcip.sequence;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.L_Result;
import pl.erizo.jcstress.playground.jcip.UnsafeSequence;

@JCStressTest
@Outcome(id = "2", expect = Expect.ACCEPTABLE, desc = "Incremented twice")
@State
public class UnsafeSequenceJcstress {

    private UnsafeSequence unsafeSequence = new UnsafeSequence();

    @Actor
    public void actor1() {
        unsafeSequence.increment();
    }

    @Actor
    public void actor2() {
        unsafeSequence.increment();
    }

    @Arbiter
    public void arbiter(L_Result result) {
        result.r1 = unsafeSequence.getX();
    }
}

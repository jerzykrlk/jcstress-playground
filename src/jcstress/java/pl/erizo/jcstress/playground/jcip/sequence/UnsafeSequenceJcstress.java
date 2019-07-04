package pl.erizo.jcstress.playground.jcip.sequence;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.J_Result;

@JCStressTest
@Outcome(id = "6", expect = Expect.ACCEPTABLE, desc = "Incremented twice")
@State
public class UnsafeSequenceJcstress {

    private UnsafeSequence unsafeSequence = new UnsafeSequence();

    @Actor
    public void actor1() {
        unsafeSequence.getNext();
    }

    @Actor
    public void actor2() {
        unsafeSequence.getNext();
    }

    @Actor
    public void actor3() {
        unsafeSequence.getNext();
    }

    @Actor
    public void actor4() {
        unsafeSequence.getNext();
    }

    @Actor
    public void actor5() {
        unsafeSequence.getNext();
    }

    @Actor
    public void actor6() {
        unsafeSequence.getNext();
    }

    @Arbiter
    public void arbiter(J_Result result) {
        result.r1 = unsafeSequence.getX();
    }
}

package pl.erizo.jcstress.playground.jcip.holder;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.Z_Result;

@JCStressTest
@State
@Outcome(id = "true", expect = Expect.ACCEPTABLE, desc = "holder is safe")
public class UnsafeHolderConstructorJcstress {

    private UnsafeHolder unsafeHolder;

    private int n = 5;

    @Actor
    public void actor1() {
        this.unsafeHolder = new UnsafeHolder(n);
    }

    @Actor
    public void actor2(Z_Result result) {
        if (unsafeHolder != null) {
            result.r1 = unsafeHolder.assertSanity();
        } else {
            result.r1 = true;
        }
    }

}

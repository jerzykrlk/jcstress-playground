package pl.erizo.jcstress.playground.jcip.immutable;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.Z_Result;

@JCStressTest
@State
@Outcome(id = "true", expect = Expect.ACCEPTABLE, desc = "published completely or not yet published")
public class AssertSanityJcstress {

    private AssertSanity assertSanity;

    private int x = 5;

    @Actor
    public void actor1() {
        this.assertSanity = new AssertSanity(x);
    }

    @Actor
    public void actor2(Z_Result result) {
        if (assertSanity != null) {
            result.r1 = assertSanity.assertSanity();
        }
        result.r1 = true;
    }


}

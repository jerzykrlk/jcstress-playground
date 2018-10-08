package pl.erizo.jcstress.playground.jcip.immutable;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "6, 12", expect = Expect.ACCEPTABLE, desc = "both initialized")
@Outcome(id = "-1, -1", expect = Expect.ACCEPTABLE, desc = "not seen yet")
public class SimplePojoDefaultConstructorJcstress {

    private SafePublication safePublication;

    private int x = -1;

    private int y = -1;

    @Actor
    public void actor1() {
        safePublication = new SafePublication();
    }

    @Actor
    public void actor2(II_Result result) {
        if (safePublication != null) {
            result.r1 = safePublication.getX();
            result.r2 = safePublication.getY();
        } else {
            result.r1 = -1;
            result.r2 = -1;
        }
    }

}

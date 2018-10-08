package pl.erizo.jcstress.playground.jcip.immutable;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "6, 12", expect = Expect.ACCEPTABLE, desc = "both initialized")
@Outcome(id = "-1, -1", expect = Expect.ACCEPTABLE, desc = "not seen yet")
public class SimplePojoDefaultConstructorJcstress {

    private SimplePojo simplePojo;

    private int x = -1;

    private int y = -1;

    @Actor
    public void actor1() {
        simplePojo = new SimplePojo();
    }

    @Actor
    public void actor2(II_Result result) {
        if (simplePojo != null) {
            result.r1 = simplePojo.getX();
            result.r2 = simplePojo.getY();
        } else {
            result.r1 = -1;
            result.r2 = -1;
        }
    }

}

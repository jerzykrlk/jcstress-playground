package pl.erizo.jcstress.playground.counter;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "3, 4", expect = Expect.ACCEPTABLE, desc = "both initialized")
@Outcome(id = "-1, -1", expect = Expect.ACCEPTABLE, desc = "not seen yet")
public class SimplePojoJcstress {

    private SimplePojo simplePojo;

    private int x = -1;

    private int y = -1;

    @Actor
    public void actor1() {
        simplePojo = new SimplePojo(3, 4);
    }

    @Actor
    public void actor2() {
        if (simplePojo != null) {
            this.x = simplePojo.getX();
            this.y = simplePojo.getY();
        }
    }

    @Arbiter
    public void arbiter(II_Result result) {
        result.r1 = x;
        result.r2 = y;
    }
}

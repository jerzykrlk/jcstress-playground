package pl.erizo.jcstress.playground.jcip.immutable;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "-1, -1", expect = Expect.ACCEPTABLE, desc = "not published yet")
@Outcome(id = "3, 4", expect = Expect.ACCEPTABLE, desc = "published and initialized")
public class SafePublicationJcstress {

    private SafePublication safePublication;

    /**
     * add values through a variable instead of inline int
     */
    private int initialX = 3;
    private int initialY = 4;

    private int x = -1;

    private int y = -1;

    @Actor
    public void actor1() {
        safePublication = new SafePublication(initialX, initialY);
    }

    @Actor
    public void actor2() {
        if (safePublication != null) {
            this.x = safePublication.getX();
            this.y = safePublication.getY();
        }
    }

    @Arbiter
    public void arbiter(II_Result result) {
        result.r1 = x;
        result.r2 = y;
    }
}

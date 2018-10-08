package pl.erizo.jcstress.playground.jvm.tearing;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.J_Result;

@JCStressTest
@State
@Outcome(id = "100", expect = Expect.ACCEPTABLE, desc = "initial value")
@Outcome(id = "-1", expect = Expect.ACCEPTABLE, desc = "target value 1")
public class WordTearingJcstress {

    private long value = 100;

    @Actor
    public void actor1() {
        value = -1;
    }


//    @Actor
//    public void actor2() {
//        value = 17179869183L;
//    }
//
    @Actor
    public void actor3(J_Result result) {
        result.r1 = value;
    }

}

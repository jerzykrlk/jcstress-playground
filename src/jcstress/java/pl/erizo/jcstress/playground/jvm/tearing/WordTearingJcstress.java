package pl.erizo.jcstress.playground.jvm.tearing;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.J_Result;

@JCStressTest
@State
@Outcome(id = "100", expect = Expect.ACCEPTABLE, desc = "initial value")
@Outcome(id = "-1", expect = Expect.ACCEPTABLE, desc = "target value 1")
public class WordTearingJcstress {

    private WordTearing wordTearing = new WordTearing(100);

    @Actor
    public void actor1() {
        wordTearing.setValue(-1);
    }


    @Actor
    public void actor3(J_Result result) {
        result.r1 = wordTearing.getValue();
    }

}

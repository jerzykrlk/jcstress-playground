package pl.erizo.jcstress.playground.jcip.wordtearing;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.L_Result;

@JCStressTest
@Outcome(id = "-281470681808896", expect = Expect.ACCEPTABLE, desc = "before XOR")
@Outcome(id = "281470681808895", expect = Expect.ACCEPTABLE, desc = "after XOR")
@State
public class WordTearingJcstress {

    private WordTearing wordTearing = new WordTearing(0x0000_ffff_0000_ffffL);

    long a = 0xffff_0000_ffff_0000L;

    @Actor
    public void actor1() {
        wordTearing.xor();
    }

    @Actor
    public void actor2(L_Result result) {
        result.r1 = wordTearing.getX();
    }

}

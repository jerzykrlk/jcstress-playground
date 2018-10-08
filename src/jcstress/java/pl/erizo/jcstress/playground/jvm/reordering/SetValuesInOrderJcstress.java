package pl.erizo.jcstress.playground.jvm.reordering;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IIII_Result;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@Outcome(id = "0, 0, 0, 0", expect = Expect.ACCEPTABLE, desc = "values not set")
@Outcome(id = "1, 0, 0, 0", expect = Expect.ACCEPTABLE, desc = "set in order")
@Outcome(id = "1, 2, 0, 0", expect = Expect.ACCEPTABLE, desc = "set in order")
@Outcome(id = "1, 2, 3, 0", expect = Expect.ACCEPTABLE, desc = "set in order")
@Outcome(id = "1, 2, 3, 4", expect = Expect.ACCEPTABLE, desc = "set in order")
@State
public class SetValuesInOrderJcstress {
    private SetValuesInOrder setValuesInOrder = new SetValuesInOrder();

    @Actor
    public void setValues() {
        setValuesInOrder.setValues(1, 2, 3, 4);
    }

    @Actor
    public void readValues(IIII_Result result) {
        result.r1 = setValuesInOrder.getA();
        result.r2 = setValuesInOrder.getB();
        result.r3 = setValuesInOrder.getC();
        result.r4 = setValuesInOrder.getD();
    }
}

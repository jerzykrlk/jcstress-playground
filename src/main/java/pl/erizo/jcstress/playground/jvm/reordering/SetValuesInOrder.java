package pl.erizo.jcstress.playground.jvm.reordering;

public class SetValuesInOrder {

    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;

    public void setValues(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

}

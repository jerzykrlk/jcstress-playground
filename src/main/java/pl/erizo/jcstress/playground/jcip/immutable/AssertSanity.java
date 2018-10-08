package pl.erizo.jcstress.playground.jcip.immutable;

public class AssertSanity {
    private int n;

    public AssertSanity(int n) {
        this.n = n;
    }

    public boolean assertSanity() {
        return (n == n);
    }
}

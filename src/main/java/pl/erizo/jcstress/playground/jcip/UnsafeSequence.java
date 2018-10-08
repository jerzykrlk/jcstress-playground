package pl.erizo.jcstress.playground.jcip;

public class UnsafeSequence {
    private long x;

    public UnsafeSequence(long x) {
        this.x = x;
    }

    public UnsafeSequence() {
        this.x = 0;
    }

    public synchronized void increment() {
        x++;
    }

    public long getX() {
        return x;
    }
}
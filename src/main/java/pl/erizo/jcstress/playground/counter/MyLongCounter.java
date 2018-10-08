package pl.erizo.jcstress.playground.counter;

public class MyLongCounter {
    private long x;

    public MyLongCounter(long x) {
        this.x = x;
    }

    public MyLongCounter() {
        this.x = 0;
    }

    public synchronized void increment() {
        x++;
    }

    public long getX() {
        return x;
    }
}

package pl.erizo.jcstress.playground.jcip.immutable;

public class SimplePojo {
    private int x;
    private int y;

    public SimplePojo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public SimplePojo() {
        this.x = 6;
        this.y = 12;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

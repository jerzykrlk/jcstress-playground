package pl.erizo.jcstress.playground.jcip.wordtearing;

public class WordTearing {
    private long x;

    public WordTearing(long x) {
        this.x = x;
    }

    public long getX() {
        return x;
    }

    public void xor() {
        x = ~x;
    }
}

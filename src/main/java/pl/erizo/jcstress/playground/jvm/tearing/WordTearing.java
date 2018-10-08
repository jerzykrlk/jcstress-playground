package pl.erizo.jcstress.playground.jvm.tearing;

public class WordTearing {

    private long value;

    public WordTearing(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

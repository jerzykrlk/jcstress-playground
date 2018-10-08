package pl.erizo.jcstress.playground.jcip.lazyinit;

public class LazyInitRace {
    private LazyInitRace instance = null;

    public LazyInitRace getInstance() {
        if (instance == null) {
            instance = new LazyInitRace();
        }
        return instance;
    }

}

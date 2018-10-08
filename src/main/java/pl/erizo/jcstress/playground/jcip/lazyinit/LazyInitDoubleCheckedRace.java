package pl.erizo.jcstress.playground.jcip.lazyinit;

public class LazyInitDoubleCheckedRace {

    private LazyInitDoubleCheckedRace instance = null;

    public LazyInitDoubleCheckedRace getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new LazyInitDoubleCheckedRace();
                }
            }
        }
        return instance;
    }

}

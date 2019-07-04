package pl.erizo.jcstress.playground.jcip.holder;

public class UnsafeHolder {

    // with non-volatile anc C2, local caching kicks in, n == n
//    private int n;

    // with volatile, more errors come up
    private volatile int n;

    public UnsafeHolder(int n) {
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    /**
     * This seems to be working fine. Somehow.
     * @return
     */
    public boolean assertSanity() {

        if (n != n) {
            return false;
        }
        return true;
    }
}

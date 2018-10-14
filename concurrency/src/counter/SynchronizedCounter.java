package counter;

/**
 * Thread safe Counter which utilizes Java's synchronized keyword.
 */
public class SynchronizedCounter implements Counter {
    private long count = 0;

    @Override
    public synchronized void add(long value) {
        count += value;
    }

    @Override
    public long getCount() {
        return count;
    }
}

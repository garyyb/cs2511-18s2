package counter;

/**
 * Unsafe (Unsynchronized) UnsafeCounter Class
 */
public class UnsafeCounter implements Counter {
    private long count = 0;

    @Override
    public void add(long value) {
        count += value;
    }

    @Override
    public long getCount() {
        return count;
    }
}

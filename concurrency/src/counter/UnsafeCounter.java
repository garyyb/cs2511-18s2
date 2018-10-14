package counter;

/**
 * Unsafe (Unsynchronized) Counter Class
 */
public class Counter {
    private long count = 0;

    public void add(long value) {
        count += value;
    }

    public long getCount() {
        return count;
    }
}

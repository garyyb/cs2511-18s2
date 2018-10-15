package boundedqueue;

/**
 * Created by red on 22-May-18.
 */
public interface BoundedQueue<E> {
    E remove();
    void add(E n);
    boolean isFull();
    boolean isEmpty();
}

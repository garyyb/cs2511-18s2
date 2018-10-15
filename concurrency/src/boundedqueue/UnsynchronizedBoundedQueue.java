package boundedqueue;

/**
 * Created by red on 22-May-18.
 */
public class UnsynchronizedBoundedQueue<E> implements BoundedQueue<E> {
    private E[] elems;
    private int capacity;
    private int head;
    private int tail;
    private int size;

    public UnsynchronizedBoundedQueue(int capacity) {
        this.elems = (E[])(new Object[capacity]);
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public E remove() {
        E e = elems[head];
        head = (head + 1) % capacity;
        size--;
        return e;
    }

    public void add(E e) {
        elems[tail] = e;
        tail = (tail + 1) % capacity;
        size++;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

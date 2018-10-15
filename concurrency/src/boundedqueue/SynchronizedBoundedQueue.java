package boundedqueue;

/**
 * Created by red on 22-May-18.
 */
public class SynchronizedBoundedQueue<E> implements BoundedQueue<E> {
    private E[] elems;
    private int capacity;
    private int head;
    private int tail;
    private int size;

    public SynchronizedBoundedQueue(int capacity) {
        this.elems = (E[])(new Object[capacity]);
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public synchronized E remove() {
        E e = null;

        try {
            while (isEmpty()) {
                wait();
            }

            e = elems[head];
            head = (head + 1) % capacity;
            size--;
        } catch (InterruptedException ex) {
        } finally {
        	notifyAll();
        }

        return e;
    }

    public synchronized void add(E e) {
        try {
            while (isFull()) {
                wait();
            }

            elems[tail] = e;
            tail = (tail + 1) % capacity;
            size++;
        } catch (InterruptedException ex) {
        } finally {
        	notifyAll();
        }

    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

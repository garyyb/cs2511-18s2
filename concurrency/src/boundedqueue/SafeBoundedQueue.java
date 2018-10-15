package boundedqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by red on 22-May-18.
 */
public class SafeBoundedQueue<E> implements BoundedQueue<E> {
    private E[] elems;
    private int capacity;
    private int head;
    private int tail;
    private int size;

    private Lock qLock;
    private Condition notFull;
    private Condition notEmpty;

    public SafeBoundedQueue(int capacity) {
        this.elems = (E[])(new Object[capacity]);
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.size = 0;

        this.qLock = new ReentrantLock();
        this.notFull = qLock.newCondition();
        this.notEmpty = qLock.newCondition();
    }

    public E remove() {
        qLock.lock();
        E e = null;

        try {
            while (isEmpty()) {
                notEmpty.await();
            }

            e = elems[head];
            head = (head + 1) % capacity;
            size--;

            notFull.signal();
        } catch (InterruptedException ex) {
        } finally {
            qLock.unlock();
        }

        return e;
    }

    public void add(E e) {
        qLock.lock();

        try {
            while (isFull()) {
                notFull.await();
            }

            elems[tail] = e;
            tail = (tail + 1) % capacity;
            size++;

            notEmpty.signalAll();
        } catch (InterruptedException ex) {
        } finally {
            qLock.unlock();
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

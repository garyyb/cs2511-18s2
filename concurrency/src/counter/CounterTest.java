package counter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @Test
    void testUnsafeCounter() throws InterruptedException {
        UnsafeCounter counter = new UnsafeCounter();

        // Create Threads
        Thread t1 = new Thread(new Producer(counter));
        Thread t2 = new Thread(new Producer(counter));

        // Run each thread.
        t1.start();
        t2.start();

        // Wait for the threads to finish.
        t1.join();
        t2.join();

        long expected = 200;
        assertEquals(expected, counter.getCount());
    }

    @Test
    void testLockedCounter() throws InterruptedException {
        LockedCounter counter = new LockedCounter();

        // Create Threads
        Thread t1 = new Thread(new Producer(counter));
        Thread t2 = new Thread(new Producer(counter));

        // Run each thread.
        t1.start();
        t2.start();

        // Wait for the threads to finish.
        t1.join();
        t2.join();

        long expected = 200;
        assertEquals(expected, counter.getCount());
    }

    @Test
    void testSynchronizedCounter() throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();

        // Create Threads
        Thread t1 = new Thread(new Producer(counter));
        Thread t2 = new Thread(new Producer(counter));

        // Run each thread.
        t1.start();
        t2.start();

        // Wait for the threads to finish.
        t1.join();
        t2.join();

        long expected = 200;
        assertEquals(expected, counter.getCount());
    }
}
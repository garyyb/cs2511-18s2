package boundedqueue;

/**
 * Created by red on 22-May-18.
 */
public class Producer implements Runnable {
    private int start;
    private int end;
    private BoundedQueue<Integer> q;

    public Producer(int start, int end, BoundedQueue<Integer> q) {
        this.start = start;
        this.end = end;
        this.q = q;
    }

    @Override
    public void run() {
        try {
            int i = start;
            while (i <= end) {
                if (!q.isFull()) {
                    q.add(i);
                    i++;
                }
                Thread.sleep(10);
            }
        } catch(InterruptedException e) {
            System.out.println("Producer was interrupted.");
        }
    }
}


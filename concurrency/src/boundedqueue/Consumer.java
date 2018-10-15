package boundedqueue;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by red on 22-May-18.
 */
public class Consumer implements Runnable {
    private int count;
    private BoundedQueue<Integer> q;
    private Set<Integer> consumed;

    public Consumer(int count, BoundedQueue<Integer> q) {
        this.count = count;
        this.q = q;
        this.consumed = new LinkedHashSet<>();
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (i <= count) {
                if (!q.isEmpty()) {
                    Integer toConsume = q.remove();
                    if (consumed.contains(toConsume)) {
                        System.out.println("Consumed already consumed " + toConsume + "!");
                    } else {
                        consumed.add(toConsume);
                        System.out.println("Consumed " + toConsume);
                    }

                    i++;
                }
                Thread.sleep(10);
            }

            System.out.println("Consumed " + consumed.size() + " unique items.");
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted.");
        }
    }
}


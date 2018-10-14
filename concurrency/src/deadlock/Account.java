package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    double balance = 0.0;
    private Lock accountLock = new ReentrantLock();

    void withdraw(double amount) {
        balance -= amount;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void lock() {
        accountLock.lock();
    }

    void unlock() {
        accountLock.unlock();
    }

    void transfer(Account to, double amount) {
        this.lock();
        to.lock();

        this.withdraw(amount);
        to.deposit(amount);

        to.unlock();
        this.unlock();
    }
}

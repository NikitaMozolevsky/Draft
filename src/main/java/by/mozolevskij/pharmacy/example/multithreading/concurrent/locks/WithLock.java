package by.mozolevskij.pharmacy.example.multithreading.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WithLock {

    private int count = 0;

    Lock lock = new ReentrantLock();

    public void icrement() {
        try {
            lock.lock();
            this.count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        try {
            lock.lock();
            return this.count;
        } finally {
            lock.unlock();
        }
    }

}

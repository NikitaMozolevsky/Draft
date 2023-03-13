package by.mozolevskij.pharmacy.example.multithreading.concurrent.locks;

//добавляет 1 и читает
public class WithSynchronized {

    private int count = 0;

    public synchronized void increment() {
        this.count++;
    }

    public synchronized int getCount() {
        return this.count;
    }

}

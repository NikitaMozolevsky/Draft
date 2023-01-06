package by.mozolevskij.pharmacy.example.multithreading;

public class ThreadExample extends Thread {

    public ThreadExample() {
        this.start();
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + " gives way to others");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }

    public static void main(String[] args) {
        new ThreadExample();
        new ThreadExample();
        new ThreadExample();
        ThreadExample1 threadExample1 = new ThreadExample1();
        threadExample1.start();
    }

    static class ThreadExample1 extends Thread {
        @Override
        public void run() {
            System.out.println("extends Thread run");
        }
    }
}

    /*Вывод в консоль будет выглядеть так:

        Thread-0 уступает свое место другим
        Thread-1 уступает свое место другим
        Thread-2 уступает свое место другим
        Thread-1 закончил выполнение.
        Thread-0 закончил выполнение.
        Thread-2 закончил выполнение.*/
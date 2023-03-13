package by.mozolevskij.pharmacy.example.multithreading.concurrent.executor;

import java.util.concurrent.Executor;

public class ExecutorExample {

    public static void main(String []args) throws Exception {

    }

    //типовой код, но каждый раз придется повторять:
    // Thread thread = new Thread(task);
    // thread.start();
    // С этим помогает executor service
    public static void typicalCode() {
        Runnable task = () -> System.out.println("Task executed");
        Thread thread = new Thread(task);
        thread.start();
    }

    //есть возможность вынести код запуска потока в отдельный метод
    public static void executorCode() {
        Runnable task = () -> System.out.println("Task executed");
        Executor executor = e -> new Thread(e).start();
        executor.execute(task);
    }

}

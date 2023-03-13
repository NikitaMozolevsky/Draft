package by.mozolevskij.pharmacy.example.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

    //интерфейс Callable - Functional, have method CALL()
    //can RETURN some value, also it THROWS Exception BY DEFAULT

    Callable task = () -> {
        return "Hello, World!";
    };

    //Future - интерфейс, позволяет получить будующее значение
    //выполненное в Callable,
    public static void getFuture() throws ExecutionException, InterruptedException {

        Callable task = () -> {
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();

        //получение результата из FutureTask
        //during executing get() - executing becomes synchronized
        System.out.println(future.get());

    }

}

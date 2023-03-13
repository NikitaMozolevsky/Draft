package by.mozolevskij.pharmacy.example.pattern.other.producer_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer<T> {
    private BlockingQueue<T> blockingQueue = new ArrayBlockingQueue<>(42, false);


}

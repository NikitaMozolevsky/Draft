package by.mozolevskij.pharmacy.example.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Task87Example {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 55, 43, 77, 876));
        CountDownLatch cdl = new CountDownLatch(arrayList.size());
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {

            int finalI = i;
            boolean atomicBoolean = false;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    arrayList.set(finalI, arrayList.get(finalI)+1);
                    cdl.countDown();
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println(arrayList);
    }

    public synchronized static void arrayChanger(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, arrayList.get(i)+1);
        }
    }
}

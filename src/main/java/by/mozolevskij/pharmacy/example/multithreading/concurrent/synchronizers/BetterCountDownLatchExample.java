package by.mozolevskij.pharmacy.example.multithreading.concurrent.synchronizers;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**Race*/
public class BetterCountDownLatchExample {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(8);

    private static final int trackLength = 500000;

    /**CountDownLatch(int someInt)
     * Потоки ожидают до тех пор, пока не завершится определенное количество
     * countDown() методов, после этого все ожидающие потоки разблокируются*/

    public static void main(String[] args) throws InterruptedException {

        //запуск потоков (5 машин)
        for (int i = 0; i < 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1000);
        }


        //в примере в  habr > 3 !x`
        while (COUNT_DOWN_LATCH.getCount() == 3) {
            Thread.sleep(1000);
            System.out.println("На старт!");
            COUNT_DOWN_LATCH.countDown();//Команда дана, уменьшаем счетчик на 1
            Thread.sleep(1000);
            System.out.println("Внимание!");
            COUNT_DOWN_LATCH.countDown();//Команда дана, уменьшаем счетчик на 1
            Thread.sleep(1000);
            System.out.println("Марш!");
            COUNT_DOWN_LATCH.countDown();
        }
    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;//считаем, что скорость автомобиля постоянная

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);

            //выполнено одно условие - счетчик снизился
            COUNT_DOWN_LATCH.countDown();

            //поток будет в сосотоянии ожидания, пока
            //счетчик не станет равным нулю
            COUNT_DOWN_LATCH.await();

            //по идее все потоки запущены одновременно
            //машины едут к финишу
            Thread.sleep(trackLength/carSpeed);
            System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
        }
    }
}

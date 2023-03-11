package by.mozolevskij.pharmacy.example.multithreading.concurrent.synchronizers;


import java.util.concurrent.Semaphore;

// Доступ управляется с помощью счётчика: изначально значение счётчика равно
// int permits, когда поток заходит в заданный блок кода, то значение
// счётчика уменьшается на единицу, когда поток его покидает,
// то увеличивается.
public class SemaphoreExample {
    //Существует парковка, которая одновременно может вмещать не более 5 автомобилей.
    // Если парковка заполнена полностью, то вновь прибывший автомобиль должен
    // подождать пока не освободится хотя бы одно место. После этого он сможет
    // припарковаться.

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Parking.Car(i)).start();
            Thread.sleep(400);
        }
    }

    /*public static void main(String[] args) {
        //permits - количество доступов
        //fair (честность) - получение доступа в порядке очереди
        //Semaphore(int permits) Semaphore(int permits, boolean fair)
        Semaphore semaphore = new Semaphore(8);

    }*/

    //5 парковочных мест
    protected class Parking {

        private static final boolean[] PARKING_PLACES = new boolean[5];
        //Устанавливаем флаг "справедливый", в таком случае метод
        //aсquire() будет раздавать разрешения в порядке очереди
        private static final Semaphore SEMAPHORE = new Semaphore(5, true);



        public static class Car implements Runnable {

            private int carNumber;

            public Car(int carNumber) {
                this.carNumber = carNumber;
            }

            @Override
            public void run() {
                //printf!!! println - doesn't work!!!
                System.out.printf("Автомобиль №%d подъехал к парковке.\n", carNumber);

                try {
                    //запрашивает достук к следующему за этим мызовом
                    //блоку кода, если разрешает - пропускает,
                    //нет - если счетчик рассчитан
                    SEMAPHORE.acquire();

                    //заглушка, если не будет, не
                    //сработает метод освобаждающий праковку, так как
                    //по переменной parkingNumber получаем место в массиве
                    //парковок которое необходиму присвоить false
                    int parkingNumber = 999;

                    //парковочных мест столько, сколько и permits в семафоре
                    //т.к. выведется ошика выхода за границы массива
                    synchronized (PARKING_PLACES) {
                        for (int i = 0; i < PARKING_PLACES.length; i++) {
                            //если парковочное место - false, то есть не заняти
                            //оно занимается,
                            if (!PARKING_PLACES[i]) {
                                PARKING_PLACES[i] = true;

                                //parkingNumber (за рамками цикла)
                                // присваивается переменная, которая означает последнее
                                //парковочное место которое было занято
                                parkingNumber = i;
                                System.out.printf("Автомобиль №%d припарковался на месте %d.\n", carNumber, i);
                                //цикл должен окончится, т.к. перебор окоончился
                                // и парковочное место уже занято
                                break;
                            }
                        }
                    }

                    Thread.sleep(5000);

                    synchronized (PARKING_PLACES) {
                        PARKING_PLACES[parkingNumber] = false;
                    }

                    SEMAPHORE.release();
                    System.out.printf("Автомобиль №%d покинул парковку.\n", carNumber);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); //sonarlint
                }
            }
        }

    }

}

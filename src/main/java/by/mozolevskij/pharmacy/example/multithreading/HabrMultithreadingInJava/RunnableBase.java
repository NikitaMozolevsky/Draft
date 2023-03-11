package by.mozolevskij.pharmacy.example.multithreading.HabrMultithreadingInJava;

public class RunnableBase {

    private RunnableBase() {
    }

    /**Runnable*/
    static class SomeThing1 implements Runnable {

        @Override
        public void run() {
            System.out.println("run method of class which implements Runnable");
        }

        public static void main(String[] args) {
            SomeThing1 someThing = new SomeThing1();
            Thread thread = new Thread(someThing);
            thread.start();
            /**класс Thread может принимать в конструктор
             *  Runnable, если мы реализуем классом SomeThing1
             * интерфейс Runnable, то создав new Thread и передав туда
             * этот класс, мы создаем поток этого класса, он запускается
             * */
        }
    }
    static class SomeThing2 {

        /** Runnable - функциональный*/

        public static void main(String[] args) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run method of class which implements Runnable" +
                            "as an anonymous class");
                }
            });
            thread.start();
        }
    }
    static class SomeThing3 {
        public static void main(String[] args) {
            Runnable runnable = (() -> System.out.println("run thread as a stream"));
            runnable.run();
        }
    }
}

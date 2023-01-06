package by.mozolevskij.pharmacy.example.multithreading.HabrMultithreadingInJava;

public class EggOrChicken {

    static class ForTheChicken extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Chicken");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("dispute started");
        ForTheChicken forTheChicken = new ForTheChicken();
        forTheChicken.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Egg");
        }
        if (forTheChicken.isAlive()) {
            try {
                forTheChicken.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chicken ");
        }
    }
}

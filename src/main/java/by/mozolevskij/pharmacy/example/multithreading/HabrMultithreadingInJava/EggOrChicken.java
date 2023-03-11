package by.mozolevskij.pharmacy.example.multithreading.HabrMultithreadingInJava;

public class EggOrChicken {

    //что было первым курица или яйцо
    //кто скажет последнее слово тот и выйграл
    static class ForTheChicken extends Thread {

        //поток отвечающий за курицу
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Chicken");
            }
        }
    }

    //майн поток отвечает за яйцо (main)
    public static void main(String[] args) {
        System.out.println("dispute started");
        ForTheChicken forTheChicken = new ForTheChicken();
        forTheChicken.start();//запуск куриного потока
        for (int i = 0; i < 5; i++) {//запуск яичного потока
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Egg");
        }
        //если поток курицы все еще работает в то время как
        //поток яйца (main) завершен,
        // Chicken будет послудним словом
        // происходит ожидание завершения
        //потока курицы forTheChicken.join(), и затем выводится Chicken
        //можено добавить else и вывести Egg если последнее слово
        //будет Egg
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

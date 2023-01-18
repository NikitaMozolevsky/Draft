package by.mozolevskij.pharmacy.example.IO;

import java.io.*;

public class IOStreams {
    /**
     * Stream - последовательность данных
     * <p>
     * java.io - работа с чтение и запись данных в ресурс:
     * Файл, работа с сетевым подключением, System.in/out/(err), при работе с буффером
     * <p>
     * Чтение данных: Ресурс -> InputStream/Reader (входящий поток) -> Service
     * Запись данных: Service -> OutputStream/Writer (исходящий поток) -> Destination
     * <p>
     * Типы потоков: Символьный (Reader/Writer), Байтовый (InputStream/OutputStream)
     * <p>
     * InputStream/Reader имеет 3 метода int read(), если возвращается -1 - нечего считывать
     * OutputStream/Writer имеет 3 метода write()
     * <p>
     * В случае буфферизации, или отправки информации порционно, а не отдельно каждый элемент (BufferedWriter),
     * метод flush() окончательно отправляет данные из буфера.
     * <p>
     * DataInput/DataOutput - работа с примитивными типами (интерфейсы), readInt/Long/UTF(), writeInt/Long/UTF()
     * DataInputStream/OutputStream - реализации, read передается поток и с него считывается, write - аналогично
     * <p>
     * Консольгый вывод/ввод
     * System.in/out/err (ошибка)
     */

    public static void main(String[] args) throws IOException {
        int chr;
        int total;
        int spaces = 0;

        try {
            Reader in = null;
            if (args.length == 0)
                in = new InputStreamReader(System.in);
            else
                in = new FileReader(args[0]);
            for (total = 0; (chr = in.read()) != -1; total++) { //повторяить цикл пока не будет -1
                if (Character.isWhitespace((char) chr))
                    spaces++;
            }
            System.out.println("Количество символов : " +
                    total + "\nКоличество пробелов : " + spaces);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

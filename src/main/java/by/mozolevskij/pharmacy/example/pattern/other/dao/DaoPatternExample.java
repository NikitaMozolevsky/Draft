package by.mozolevskij.pharmacy.example.pattern.other.dao;

public class DaoPatternExample {
    public static void main(String[] args) {
        String str = String.format("Расстояние от Киева до Одессы - %.1f" +
                " Не так уж и мало, не правда ли?  ", 475.4d);
        System.out.println(str);
    }
}

class DB {
    String getFromTable;
}

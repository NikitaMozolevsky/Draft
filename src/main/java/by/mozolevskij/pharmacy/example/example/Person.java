package by.mozolevskij.pharmacy.example.example;

public class Person {

    private String name;    // имя
    private double age;        // возраст

    /*начало блока инициализатора*/ {
        name = "Undefined";
        age = 18.4;
    }

    /*конец блока инициализатора*/
    public Person() {
    }

    private Person(String name) {

        this.name = name;
    }

    public Person(String name, double age) {

        this.name = name;
        this.age = age;
    }

    private void displayInfo() {
        System.out.printf("Name: %s \tAge: %.4f\n", name, age);
    }
}

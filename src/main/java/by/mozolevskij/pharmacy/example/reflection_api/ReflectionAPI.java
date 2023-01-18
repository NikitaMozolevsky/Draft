package by.mozolevskij.pharmacy.example.reflection_api;

import by.mozolevskij.pharmacy.example.example.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionAPI {
    /**Исследование различной информации о полях, методах, конструкторов
     * классов во время выполнения программы. Позволяет обрабатывать типы классов
     * отсувствующие при компиляции, но появившиеся позже
     *
     * Рефлексия позволяет:
     * Узнать/определить класс объекта;
     * Получить информацию о модификаторах класса, полях, методах, константах, конструкторах и суперклассах;
     * Выяснить, какие методы принадлежат реализуемому интерфейсу/интерфейсам;
     * Создать экземпляр класса, причем имя класса неизвестно до момента выполнения программы;
     * Получить и установить значение поля объекта по имени;
     * Вызвать метод объекта по имени.
     *
     *
     * */

    public static void main(String[] args) throws Exception {

        Person person = new Person("Name", 12);

        //способы получения объекта класса
        Class clss = new Person().getClass();
        Class clss2 = Person.class;
        Class clss3 = Class.forName("by.mozolevskij.pharmacy.example.example.Person");
        //Существуют случаи когда класс находится в скомпилированной библиотеке
        //или закрытом модуле, или в классе нет getter-ов, но нужно получить значение private поля

        //способ получить поля класса
        clss.getFields();

        //способ получить приватные поля класса
        clss.getDeclaredFields();

        //способ получить поле класса
        clss.getField("age");

        //способ получить приватное и протектед поле класса
        //получение объекта Field c которым можно работать
        Field field = clss.getDeclaredField("age");//имя нужного поля
        field.setAccessible(true);//установление возможности работы с private/protected полем
        field.get(person);//теперь можно получить значение этого поля методом get()

        //если у класса нет setter-ов можно сделать и его
        field.set(person, 23); //учтановление нового значения person.age, хотя у класса
        //нет сеттеров

    }
}

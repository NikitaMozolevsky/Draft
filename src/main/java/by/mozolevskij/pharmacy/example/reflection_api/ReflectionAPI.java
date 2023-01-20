package by.mozolevskij.pharmacy.example.reflection_api;

import by.mozolevskij.pharmacy.example.example.Person;
import com.mysql.cj.xdevapi.Collection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

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
        Person person2 = new Person("Name", 12);
        Person person3 = new Person("Name", 12);

        //способы получения объекта класса
        Class<?> clss1 = new Person().getClass();
        Class<?> clss = Person.class;
        Class<?> clss3 = Class.forName("by.mozolevskij.pharmacy.example.example.Person");
        //Существуют случаи когда класс находится в скомпилированной библиотеке
        //или закрытом модуле, или в классе нет getter-ов, но нужно получить значение private поля

        //способ получить поля класса
        Arrays.stream(clss.getFields()).map(String::valueOf).peek(System.out::println);

        //способ получить приватные поля класса
        System.out.println(clss.getDeclaredFields());

        //способ получить поле класса
        clss.getDeclaredField("name");

        //способ получить приватное и протектед поле класса
        //получение объекта Field c которым можно работать
        Field field = clss.getDeclaredField("age");//имя нужного поля
        field.setAccessible(true);//установление возможности работы с private/protected полем
        field.get(person);//теперь можно получить значение этого поля методом get()

        //если у класса нет setter-ов можно сделать и его
        field.set(person, 23); //учтановление нового значения person.age, хотя у класса нет сеттеров

        Class[] classes = new Class[] {String.class, double.class};

        //создание объекта класса, без слова new
        //получение конструктора с объектами класса, которые в массиве
        //создание объекта по полученному конструкору
        Person person1 = (Person) clss.getDeclaredConstructor(classes).newInstance("Name", 12);

        //получение всех конструкторов
        Constructor[] constructors = clss.getConstructors();
        Constructor[] privateProtectedConstructors = clss.getDeclaredConstructors();

        //получение всех методов
        Method[] methods = clss.getMethods();
        Method[] privateProtectedMethods = clss.getDeclaredMethods();

        //получение имен методов
        System.out.println(Arrays.stream(methods).map(method -> method.getName()).toList());

        //получение модификаторов методов
        System.out.println(Arrays.stream(methods).map(method -> method.getModifiers()).map(Modifier::toString).toList());

        //можно получать различные данные, параметры методов, возвращаемые значение и т.д.
        System.out.println(Arrays.stream(clss.getDeclaredFields()).map(Field::getName));//имена полей

        for (Method method : methods) {
            method.invoke(clss, "someArgs");//вызов метода класса для какого-то объекта, throw Exception
        }

        //херня собачья, не хочет проходить по всему стриму, мои полномочия все
        //попытка получить имена полей (вероятно сотому-что sout)
        System.out.println(Arrays.stream(constructors).peek(System.out::println)
                .map(constructor -> Arrays.stream(constructor.getParameters())
                        .peek(System.out::println)).toList());

        System.out.println(Arrays.stream(constructors)
                .map(constructor -> Arrays.stream(constructor.getParameters())
                        .map(parameter -> parameter.getName().length()).peek(System.out::println)).toList());

    }
}

class Test {

    public Object obj;

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException
    {

        // returns the Class object for this class
        Class myClass = Test.class;

        System.out.println("Class represented by myClass: "
                + myClass.toString());

        String fieldName = "obj";

        // Get the field of myClass
        // using getField() method
        System.out.println(
                fieldName + " Field of myClass: "
                        + myClass.getField(fieldName));
    }
}

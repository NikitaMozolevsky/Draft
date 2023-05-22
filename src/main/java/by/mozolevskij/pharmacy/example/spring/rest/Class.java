package by.mozolevskij.pharmacy.example.spring.rest;

public class Class {

    /** C:\IdeaProjects\FirstRestAlishev
     *
     * Jackson - библиотека конвертирующая Java объекты в JSON
     * и наоборот, класс должен имет геттеры и сеттера на все поля
     * Spring использует Java объекты автоматически, для этого используются
     * гесеттеры
     *
     * @ResponseBody - аннотация для метода, Spring понимает
     * что тепень возвращается не представление, а данные.
     * При возвращении объекта например Person то этот
     * объект будет конвертироваться Jackson-ом в JSON
     *
     * @RequestBody - принимает JSON от клиента, для обработки,
     * этой аннотацией помечаются те параметры в методе, кторые мы
     * молучаем от клиента
     *
     * @RestController - каждый метод помечен @ResponseBody
     * (@Controller + @ResponseBody)
     *
     * REST Обработчик ошибок - C:\IdeaProjects\FirstRestAlishev
     * \src\main\java\com\example\firstrestalishev\controllers\PeopleController.java
     * @HandleException - аннотация над методами возвращающими в теле ошибку
     *
     * DTO - Data Transfer Object, слой-java-объект, обычный Java класс,
     * используется на уровне контроллера, не используется глубже,
     * как для отправки так и для получения,
     * Эта прослойка нужна т.к. сам основный класс нужен для бизнесс логики,
     * и использовать модель для отправки данных неправильно,
     * поля модели и DTO могут отличаться, например ID поле не отправляется клиентом,
     * это поле только для модели
     *
     * ModelMapper - Maven зависимость, инструмент для быстрого переконвертации
     * Model в DTO и наоборот PeopleController convertToPerson()
     * Можно создать Singletone Bean для использования во всех местах
     * (FirstRestAlishevApplication.java)
     *
     * */

}

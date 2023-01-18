package by.mozolevskij.pharmacy.example.learning.spring_theory;

public class SpringSecurity {
    /** АУНТЕФИКАЦИЯ
     * Доказание сервису что я - зарегестрированный пользователь
     * посредством ввода логина и пароля
     *
     * АВТОРИЗАЦИЯ
     * Говорит что я как пользователь могу делать после аунтефикация
     * пользователь авторизуется на разные роли
     *
     * SpringSecurity работает посредством фильтров, фильтр перехватывает все HTTP запросы,
     * пример: фильтр PUT, PATCH, DELETE запросов
     *
     * Для реализации Security создается класс, реализующий AuthenticationProvider
     * с одним методом authenticate
     *
     * */
}

package by.mozolevskij.pharmacy.example.learning.session_cookies;

public class Cookies {

    /**
     *
     * Cookies: Пара Key = Value, хранится в браучере для конкретного сайта
     * Позволяет хранить некоторые данные у клиента,
     * Позволяет идентифицировать пользователя
     *
     * Сервер добавляет новые или меняет существующие Cookies
     *
     * Передается при каждом запросе
     *
     * В header запроса set-cookie задаются пары Key = Value
     *
     * Cookie состоит из:
     * 1) Названия, значения
     * 2) Срок действия
     * 3) Domain, Path - имя сайта и путь к кторому относится этот Cookie
     *
     * Работа с суссией:
     * 1) Сайт создает для клиента Cookie c Key "JSESSIOID",
     * кладет туда ID пользователя
     * 2) По ID позьзователя он узнает сессию пользователя
     *
     * */

}

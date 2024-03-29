package by.mozolevskij.pharmacy.example.test.mockito;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class MockitoTheory {

    /**
     *
     * Mockito - фреймворк для работы с ЗАГЛУШКАМИ, ведут себя жестко заданным образом
     * по началу все методы возвращают 0 либо NULL, это поведение можно изменить,
     * mock можно создать и для классов с приватными конструкторами (Singleton) и для
     * утилитных классов
     *
     * DataService (мой проект (by.mozolevskij.pharmacy.example.test.mockito.DataService))
     * - методы предоставляюшие доступ к данным
     *
     * Тестирование в настоящем тесте:
     *
     * настроил mock моего сервиса нужным образом;
     *
     * передал его (вероятнее всего, через конструктор) экземпляру
     * использующего его другого класса (предположим, содержащего
     * какую-то бизнес-логику, использующую предоставляемые
     * DataService данные), который я, собственно, и тестировал бы;
     *
     * задействовал функционал тестируемого класса и проконтролировал бы результаты;
     *
     * при необходимости проконтролировал бы количество и порядок вызовов
     * метода(ов) моего mock, которые должны были быть вызваны тестируемым
     * классом в результате предыдущего действия.
     *
     * */

    /**
     *
     * Такой экземпляр будет принят любым методом или конструктором, которому
     * потребуется параметр этого типа, и единственный способ отличить данный
     * mock-объект от обычного - Mockito.mockingDetails(dataServiceMock)
     *
     * */

    public static void main(String[] args) {
        //создание Mock объекта экземпляра DataService
        DataService dataServiceMock = Mockito.mock(DataService.class);
        //получение информации о том что этот объект представляет из себя с точки
        //зрения Mockito, (mock это или spy)
        Mockito.mockingDetails(dataServiceMock);


        /**
         *
         * Есть ситуации когда мы пытаемся создать Mock для final класса, или
         * Mock экземпляр Enum, или переопределить поведение final метода,
         * Mockito в таком случае перестанет работать.
         * Однако это можно изменить — достаточно создать в проекте
         * (при стандартном устройстве проектного дерева каталогов) файл
         * test/resources/mockito-extensions/org.mockito.plugins.MockMaker и
         * вписать в него строчку:
         *  mock-maker-inline
         * БЫЛО СОЗДАНО +, БЫЛО ПРОВЕРЕНО -.
         *
         * Теперь можно имитированть final классы, Enum-ы и переопределять
         * final методы
         * */

        /**
         *
         * Полученный в результате Mock бесполезен, его методы не окажут
         * никакого воздействия, возвращаемое значение методов этого Mock
         * будут null для объектных типов, 0 - для примитивных.
         * Если речь идет о коллекции - это будет пустая коллекция, а
         * вместо обычного массива - null
         * */

        /**
         *
         * Создание заглушки с реальным функционалом
         * На этот случай существуют spy-объекты, если spy создается на типе интерфейса - будет создан
         * обычный объект, если класс - будет попытка создать жкземпляр при помощи конструктора
         * без параметров, если такого нет - будет ошибка
         * */
        //создание spy-объекта
        DataService dataServiceSpy = Mockito.spy(DataService.class);

        /**
         * УПРАВЛЕНИЕ ПОВЕДЕНИЕМ MOCK-ОВ
         * Управление поведением Mock-а придерживается следующего принципа:
         * */
        //локальный объект data
        List<String> data = new ArrayList<>();
        //условные данные, котрых будет достаточно для проведения теста
        data.add("dataItem");
        //если на dataServiceMock был вызван getAllData() - вернуть data
        Mockito.when(dataServiceMock.getAllData()).thenReturn(data);

        /**
         * Основная реализация - Mockito.when():
         * Метод WHEN() возвращает OngoingStubbing объект, на котором можно вызвать один из методов
         * семейства THEN..., то есть создание реакции на вызов некоторого метода
         *
         * В примере выще это возвращение List
         * */

        /**При работе с Mockito нет цели получить реальный результат, а определить его границы,
         * указать резуьтат
         * */

        /**
         * Альтернативная реализация - Mockito.do...
         * При помоши данного метода сначала указывается результат вызова метода, методы
         * семейства do() возвращают объект класса Stubber, при помоши жтого объекта можно
         * задать условие, аналогичный результат что и выше:
         * */

        List<String> dataWithDo = new ArrayList<>();
        data.add("dataItem");
        //возвращение данных dataWithDo если на объекте dataServiceMock вызывается метод getData()
        Mockito.doReturn(dataWithDo).when(dataServiceMock).getData();

        /**
         * Mockito.when() считается предпочтительнее Mockito.do()
         * РАЗНИЦА:
         * when() - при вызове - вызывается не переопределенная версия метода, потом внутри
         * Mockito происходит переопределение
         * do() - метод do() возвращает Mock и для него вызывает переопределенная версия,
         * то есть при компиляции кода не будет проверенно подходит ли возвращаемое значение
         * метода вызванного Mock-ом к реальному методу, в случае с when() ошибки быть не может
         *
         * do() можно использовать когда у метода нет возвращаемого значения,
         * */

        /**
         * Работа c Mockito если методы принимают какие-то значения:
         * Можно реализовать реакцию на передачу в метод любого значения, или
         * можно реализовать определенное поведение при передаче тех или иных
         * данных в метод,
         * */

        //Реакция на передачу любого значения в качестве параметра
        Mockito.when(dataServiceMock.getDataItemById(any()))
                .thenReturn("dataItem");

        //Реакция на определенное значение передаваемое в метод - 1
        Mockito.when(dataServiceMock.getDataItemById("idValue"))
                .thenReturn("dataItem");
        // or
        //Реакция на определенное значение передаваемое в метод - 2
        Mockito.when(dataServiceMock.getDataItemById(Mockito.eq("idValue")))
                .thenReturn("dataItem");

        /**
         * Можно проверить передаваемый параметр и по другому
         * */
        //Когда на mock объекте вызовется getDataById() c id удовлетворяющему данному
        //условию, то данный mock метод возвратит строку "dataItem"
        Mockito.when(dataServiceMock.getDataById(
                        Mockito.argThat(arg -> arg == null || arg.length() > 5)))
                .thenReturn("dataItem");

        /**
         * Для одного метода можно написать несколько, приоритет если условия противоречат
         * друг другу будет у того есловя которое написано позже, поэтому
         * если у метода несколько параметров, то начать написание
         * есловий следует с самого простого параметра any()
         *
         * */

        /**https://habr.com/ru/post/444982/ Задание результатов вызова*/
    }
}

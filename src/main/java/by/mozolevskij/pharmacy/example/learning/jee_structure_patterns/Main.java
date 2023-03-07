package by.mozolevskij.pharmacy.example.learning.jee_structure_patterns;

public class Main {

    /**
     *
     * Паттенры бывают:
     * Порождающие - упроавляют созданием и инициализацией, выбором объекта:
     * Singleton, Factory
     *
     * Поведенческие - управляют связью, обменом сообщениями, взаимодействием
     * между объектами:
     * Observer
     *
     * Структурные - упорядочивают отношения между классами и объектами,
     * обоепечивая критерии соединения и совместного использования связанных
     * объектов для достижения желаемого поведения:
     * Decorator
     *
     * */

    MySingletonEnum mySingletonEnum = MySingletonEnum.INSTANCE; //ENUM!

}

enum MySingletonEnum {
    INSTANCE;
    public void doSomethingInteresting(){
        System.out.println("123");
    }
}
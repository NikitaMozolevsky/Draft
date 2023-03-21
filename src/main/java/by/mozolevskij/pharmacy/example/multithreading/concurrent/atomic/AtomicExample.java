package by.mozolevskij.pharmacy.example.multithreading.concurrent.atomic;

public class AtomicExample {

    /**
     * Atomic - безопасное выполенеие операций в нескольких потоках
     * без синхронизации и блокировок
     *
     * Существуют оптимистический и пессимистический подход к изменению
     * переменных в многопоточной среде:
     * ПЕССИМИСТИЧЕСКИЙ - синхронизация, и доступ к переменной только
     * одному потоку
     * ОПТИМИСТИЧЕСКИЙ - блокирвки нет, если один поток замечает, что
     * значение переменной изменилось другим потоком, то он повторяет
     * операцию снова, но уже с новым значение переменной -
     * так работают ATOMIC
     *
     * • AtomicBoolean
     * • AtomicInteger
     * • AtomicLong
     * • AtomicReference - ссылка на объект
     *
     * Содержат метод compareAndSet(int текущееПредпологаемоеЗначение, int новоеЗначение)
     * если текущееПредпологаемоеЗначение соответствует текущему действительному, то
     * значение AtomicInteger изменяется, и метод compareAndSet() возвращает true, иначе
     * compareAndSet() не изменяет значение и возвращает false
     * getAndSet() - возвращает старое значе
     *
     * • AtomicIntegerArray
     * • AtomicLongArray
     * • AtomicReferenceArray - ссылки на объекты
     *
     * */

}
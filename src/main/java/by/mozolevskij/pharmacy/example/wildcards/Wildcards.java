package by.mozolevskij.pharmacy.example.wildcards;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Wildcards {

    /**Инвариантность - невозможность содержания в массиве объектов находящихся
     *  в иерархии выше или ниже
     *
     *  Ковариантность - List<? extends Number> - возможность содержания наследникоа
     *
     *  Контрвариантность - List<? super Integer> - возможность содержания super объектов
     *  */

    /**
     *
     * List<? extends Class> - Producer - может только предоставлять объекты,
     * содержит все что Class.class и ниже
     *
     * List<? super Class> - Consumer - может только принимать объекты
     * содержит все что Class.class и выше (super)
     * Из List<? super Class> можно получить только объекты Object.class
     * */

    /**Метод переносит dest объекты в src список*/
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {

        List<Number> nums = Arrays.asList(4.1F, 0.2F);
        List<Integer> ints = Arrays.asList(1,2);
        Collections.copy(nums, ints); /**ВОзможность скопировать Integer в Number массив,
                                        невозможно сделать в обратную сторону*/


    }

    /**Collection<?> = Collection<? extends Object>, не использовать Row типы */

    /**Переменная типа <T extends Comparable<T>>, может быть ограничена только с верху,
     *  например интерфейсом Comparable
     *
     *  */

    public static <T extends Comparable<T>> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }


    /**Множественные ограницения, ограничен классом Object (для затирания типов, зачем-то)
     * и интерфейсом Comparable*/

    abstract <T extends Object & Comparable<? super T>> T max2(Collection<? extends T> coll);

}

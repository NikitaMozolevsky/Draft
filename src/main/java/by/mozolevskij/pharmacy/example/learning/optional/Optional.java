package by.mozolevskij.pharmacy.example.learning.optional;

public class Optional {

    /**
     *
     * OPTIONAL
     * orElseGet() от orElse() - работают как get(),
     *
     * orElse() - возвращает
     * переданное внутрь значение если проверяемый объект - null
     *
     * orElseGet() - похож на orElse(), но в качестве аргумента
     * принимает ИНТЕРФЕЙС Supplierя, который вызывает определенное
     * действие, возврашает Supplier тот тип что положен в Optional
     *
     * orElseThrow() - еще один подход к обработке несуществующиго значения,
     * orElseThrow(IllegalArgumentException::new) - выбразывает исключение
     * если обернутое значение отсувствует
     *
     * */

}

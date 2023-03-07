package by.mozolevskij.pharmacy.example.learning.algorithms;

public class Algorithms {

    /**
     * СОРТИРОВКИ БЫВАЮТ:
     * ПУЗЫРЬКОВАЯ - самый большой элемент сравнивается с каждым о отправляется
     * по итогу в конец, и так с каждым
     *
     * СОРТИРОВКА СЛИЯНИЕМ - рзделение массива на части -> отдельная сортировка
     * -> слияние;
     *
     * БЫВТРАЯ СОРТИРОВКА (O(n log n)) - найти любой элемент массива (опорный) ->
     * сравнить его со всеми остальными -> разделить на 3 части
     * (на практике проще на 2), где есть большие, менишие
     * и равные опорному числу (меньшие, большие и равные), рекурсивно сравнить большие и меньшие
     * если между ними разница больше еденицы
     *
     * ПИРМИДАИДАЛЬНАЯ СОРТИРОВКА - создание бинарного дерева из неотсортированного массива,
     * берется 3 низших элемента каждой втви и сравниваются меджду собой
     * наибольщее значение передается на верх и менияется местами с наименьшим,
     * и так пока на самом верху дерева не окажется самое большое число, далее самое большое
     * число удаляется из дерева, остается в начале массива как самое большое
     * и заменяется одним из тех что остались в самом
     * низу, алгоритм повторяется пока все чала не будут удалены из дерева
     *
     * А
     * ДВОИЧОГО ПОИСКА - постоянное деление на 2
     *
     * Обозначение сложности в алгоритмах - Big-O (большая O)
     * Позволяет оценить время выполнения алгоритма в зависимости от
     * переданных данных, чем больше размер, дольше алгоритм
     *
     * В случае передачи какой-либо информации на какое-либо расстояние -
     * скорость - ЛИНЕЙНАЯ, или O(N), увеличение объема передаваемого файла
     * будет увеличивать время выполнения алгоритма пропорционально (1-ин к 1-му)
     * for (int i: numbers) {
     *    System.out.println(i);
     * } - у алгоритма линейная скорость, зависит от кло-ва чисел
     *
     * public static void main(String[] args) {
     *    LinkedList<Integer> numbers = new LinkedList<>();
     *    numbers.add(0, 20202);
     *    numbers.add(0, 123);
     *    numbers.add(0, 8283);
     * } - вставка элементов в начало списка, сложность O(1), т.к. вставляем
     * в начало и не вожно сколько в списке всего элементов, происходит
     * просто переопределение ссылок
     *
     * Перевоз жесткого диска на грузовике - постоянная (КОНСТАНТНАЯ) сложность, или O(1)
     *
     * */

}

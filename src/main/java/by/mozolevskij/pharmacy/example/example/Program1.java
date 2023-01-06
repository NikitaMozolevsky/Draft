package by.mozolevskij.pharmacy.example.example;

import java.util.*;
import java.util.stream.Collectors;

public class Program1 {

    public static void main(String[] args) {
        Program1 program1 = new Program1();
        program1.someExample("addda", "aaddaa", "aoaoaoaoao", "aoaoa");
    }

    public Integer getVowels(String string) {
        int vowelNumber = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'y') {
                vowelNumber++;
            }
        }
        return vowelNumber;
    }

    public StringBuilder someExample(String... strings) {
        StringBuilder sentence = new StringBuilder();

        Comparator<String> comparator = ((s1, s2) -> getVowels(s1).compareTo(getVowels(s2)));
        List<String> list = Arrays.stream(strings).sorted(comparator)
                .collect(Collectors.toList());
        for(String string : list) {
            sentence.append(string);
            sentence.append(" ");
        }
        System.out.println(sentence);
        return sentence;
    }

    public static void sout() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 6));/*Arrays.asList(1, 2, 3, 4, 5, 7, 6);*/
        final int controlAmount = 20;
        final int discountPercent = 10;
        list.removeIf(o -> o<=4);
        System.out.println(list);
        /*Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();

        }*/
    }

}
 class Person{

    String name;    // имя
    double age;        // возраст

    /*начало блока инициализатора*/
    {
        name = "Undefined";
        age = 18.4;
    }
    /*конец блока инициализатора*/
    Person(){

    }
    Person(String name){

        this.name = name;
    }
    Person(String name, double age){

        this.name = name;
        this.age = age;
    }
    void displayInfo(){
        System.out.printf("Name: %s \tAge: %.4f\n", name, age);
    }
}
package by.mozolevskij.pharmacy.example.pattern.behavioral.iterator;

import java.util.Arrays;
import java.util.List;

public class Main {
}

interface Iterator {
    public boolean hasNext();
    public Object next();
}
interface Collection {
    Iterator getIterator();
}

class JavaDeveloper implements Collection {
    String name;
    List<String> skills;


    public JavaDeveloper(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public Iterator getIterator() {
        return new SkillIterator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    private class SkillIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index<skills.size()) {
                return true;
            }
            else {
                return false;
            }

        }

        @Override
        public Object next() {
            return skills.get(index++);
        }
    }
}

class DeveloperRunner {
    public static void main(String[] args) {
        List<String> skills = Arrays.asList("skill1", "skill2", "skill3");

        JavaDeveloper javaDeveloper = new JavaDeveloper("nikita", skills);

        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("developer: " + javaDeveloper.getName());

        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString() + " ");
        }
    }
}

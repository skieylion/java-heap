package project.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("PostgreSQL");
        skills.add("Maven");
        DeveloperCollection developerCollection = new DeveloperCollection("Eugene", skills);
        Iterator iterator = developerCollection.createIterator();
        System.out.println("name: " + developerCollection.getName());
        while (iterator.hasNext()) {
            System.out.println("skill: " + iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Collection {
    Iterator createIterator();
}

@Data
@AllArgsConstructor
class DeveloperCollection implements Collection {
    private String name;
    private List<String> skills;

    @Override
    public Iterator createIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < skills.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return skills.get(index++);
        }
    }
}


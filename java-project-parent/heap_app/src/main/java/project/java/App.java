package project.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public List<Integer> findSubstring(String s, String[] words) {
        int[] counter = new int[words.length];
        return new ArrayList<>();
    }

    //клиентский код
    public static void main(String[] args) {
        MyList myList = new MyList("петя", "федя", "ульяна", "никита");
        MyIterator myIterator = myList.creatorIterator();
        while (myIterator.hasNext()) {
            String name = myIterator.getNext();
            System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1));
        }
    }
}

//коллекция
class MyList implements MyIterable {

    final ArrayList<String> list;

    public MyList(String... names) {
        list = new ArrayList<>();
        list.addAll(Arrays.asList(names));
    }

    @Override
    public MyIterator creatorIterator() {
        return new MyListIterator(this);
    }
}

interface MyIterator {
    String getNext();

    boolean hasNext();
}

class MyListIterator implements MyIterator {

    private final MyList list;
    private int index;

    public MyListIterator(MyList list) {
        this.list = list;
        index = 0;
    }

    @Override
    public String getNext() {
        return list.list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return list.list.size() > index;
    }
}

interface MyIterable {
    MyIterator creatorIterator();
}
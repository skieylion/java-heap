package project.java;

import project.java.iterator.MyIterator;
import project.java.iterator.MyList;

public class App {
    public static void main(String[] array) {
        MyList myList = new MyList("петя", "федя", "ульяна", "никита");
        MyIterator myIterator = myList.creatorIterator();
        while (myIterator.hasNext()) {
            String name = myIterator.getNext();
            System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1));
        }
    }
}

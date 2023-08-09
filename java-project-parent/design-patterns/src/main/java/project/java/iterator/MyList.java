package project.java.iterator;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList implements MyIterable {
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

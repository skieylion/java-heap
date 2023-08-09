package project.java.iterator;

public class MyListIterator implements MyIterator {
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

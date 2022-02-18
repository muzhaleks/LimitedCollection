import java.util.Arrays;
import java.util.Iterator;

public class LimitedSetImpl<T> implements LimitedSet<T> {

    static class EntryValue<T> {
        T val;
        int counter = -1;

        EntryValue() {

        }
    }


    private EntryValue<T>[] array;


    private final int CAPACITY = 10;

    LimitedSetImpl() {
        array = new EntryValue[CAPACITY];
        for (int i = 0; i < array.length; i++) {
            array[i] = new EntryValue<>();
        }
    }

    Iterator iterator() {
        return Arrays.asList(array).iterator();
    }

    @Override
    public void add(T t) {
        int min = CAPACITY;
        int index = 0;
        boolean contains = false;

        for (int i = 0; i < array.length; i++) {
            if (t.equals((array[i].val))) {

                contains = true;
                break;
            } else if (min > array[i].counter) {
                min = array[i].counter;
                index = i;
            }
        }
        if (!contains) {
            array[index].val = t;
            array[index].counter = 0;
        }


    }

    @Override
    public boolean remove(T t) {
        for (int i = 0; i < array.length; i++) {
            if (t.equals(array[i].val)) {
                array[i] = new EntryValue<>();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T t) {
        for (EntryValue<T> entryValue : array) {
            if (t.equals(entryValue.val)) {
                entryValue.counter++;
                return true;
            }
        }
        return false;
    }


}

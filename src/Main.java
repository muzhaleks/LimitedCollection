import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LimitedSetImpl set = new LimitedSetImpl();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        set.add(60);
        set.add(70);
        set.add(80);
        set.add(90);
        set.add(100);

        set.contains(50);
        set.contains(50);

        set.add(101);
        set.contains(101);

        set.add(404);
        set.remove(30);

        set.add(505);
        set.add(505);
        set.add(300);
        set.contains(300);
        set.contains(300);
        set.contains(300);


        Iterator<LimitedSetImpl.EntryValue> entryValueIterator = set.iterator();
        while (entryValueIterator.hasNext()) {
            LimitedSetImpl.EntryValue entryValues = entryValueIterator.next();
            System.out.println("Value: " + entryValues.val + " number of compares: " + entryValues.counter);
        }

    }
}

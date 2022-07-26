package Iterator;

import java.util.*;

public class MyIterator {
    public static void main(String[] args) {
        // 1. Obtaining an iterator
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        Iterator<String> iterator = list.iterator();

        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("Two");
        set.add("Three");

        Iterator<String> iterator2 = set.iterator();

        // 2. Iterating an iterator.
        while(iterator.hasNext()) {
            Object nextObject = iterator.next();
        }

        // 3. Adding elements during iteration --> Raises Exception!!
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(123);
        numbersList.add(456);
        numbersList.add(789);

        Iterator<Integer> numIterator = numbersList.iterator();
        while (numIterator.hasNext()) {
            int value = numIterator.next();

            if (value == 123) {
                try {
                    numbersList.add(743);
                } catch (ConcurrentModificationException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // 4. Remove elements during iteration -> remove() on the latest next().
        numIterator = numbersList.iterator();
        while (numIterator.hasNext()) {
            int value = numIterator.next();

            if (value == 456) {
                iterator.remove();
            }
        }

        // 5. forEachRemaining() -> call a Lambda Function on the remaining elements of the iterator.
        List<String> stringlist = new ArrayList<>();
        stringlist.add("Jane");
        stringlist.add("Heidi");
        stringlist.add("Hannah");

        iterator = stringlist.iterator();

        // Note: Can also be replaced with a method reference.
        iterator.forEachRemaining((element) -> {
            System.out.println(element);
        });

        // 6. ListIterator -> interface that allows bidirectional traversal.
        ListIterator<String> listIterator = stringlist.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // going backwards - previous
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}

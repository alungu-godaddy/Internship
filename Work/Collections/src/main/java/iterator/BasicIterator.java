package iterator;

import java.util.*;

public class BasicIterator {
    public static void main(String[] args) {
        // 1. Obtaining an iterator.
        List<String> list =  new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();

        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");

        iterator = set.iterator();

        // 2. Iterating an iterator.
        while (iterator.hasNext()) {
            Object nextObject = iterator.next();
        }

        // 4. Remove elements during iteration --> Doesn't raise any exception.
        List<Integer> numList = new ArrayList<>();
        numList.add(123);
        numList.add(456);
        numList.add(789);

        Iterator<Integer> iterator2 = numList.iterator();
        while (iterator2.hasNext()) {
            int value = iterator2.next();

            if (value == 456) {
                iterator.remove();
            }
        }

        // 5. forEachRemaining with a Java Lambda Expression.
        List<String> stringList = new ArrayList<>();
        stringList.add("Jane");
        stringList.add("Heidi");
        stringList.add("Hannah");

        Iterator<String> stringIterator = stringList.iterator();
        stringIterator.forEachRemaining((element) -> {
            System.out.println(element);
        });

        // 6. ListIterator -> bi-directional iterator -> navigate both forward and backwards
        ListIterator<String> listIterator = stringList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // 7. Using MyIterator class.
        List<String> myList = new ArrayList<>();
        myList.add("one");
        myList.add("two");
        list.add("three");

        MyIterator<String> myIterator = new MyIterator<>(myList);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}

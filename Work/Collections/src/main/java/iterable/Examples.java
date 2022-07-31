package iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class Examples {
    public static void main(String[] args) {
        // 1. Iterating an iterable using the for-each loop.
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        for (String element : list) {
            System.out.println(element.toString());
        }

        // 2. Iterate via an iterator.
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // 3. Iterate an iterator via it's for-each method.
        list.forEach( (element) -> {
            System.out.println(element);
        });

        // 4. Obtaining a spliterator.
        Spliterator<String> spliterator = list.spliterator();

        /**
         * Note: Keep in mind that using the iterator/for-each means getting a new iterating
         * instance, so a performance decision must be made if a collection needs to be iterated over
         * many times. A classic for loop might be faster.
         */
    }
}

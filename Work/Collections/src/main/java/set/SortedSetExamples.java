package set;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExamples {
    public static void main(String[] args) {
        /**
         * Behaves like a normal set, with the exception that the elements it
         * contains are sorted internally.
         */

        // Ascending vs. Descending order.
        TreeSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("one");
        sortedSet.add("two");
        sortedSet.add("three");

        Iterator<String> iterator = sortedSet.descendingIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // Removing elements.
        sortedSet.remove("one");

        // Get first element.
        String first = sortedSet.first();

        // Get last element.
        String last  = sortedSet.last();

        // Iterate with iterator.
        SortedSet<Integer> sortedSet1 = new TreeSet<>();
        sortedSet1.add(1);
        sortedSet1.add(0);
        sortedSet1.add(45);

        Iterator<Integer> intIterator = sortedSet1.iterator();
        while (intIterator.hasNext()) {
            int value = intIterator.next();

            System.out.println(value);
        }

        // Get HeadSet.
        SortedSet<String> sortedSet2 = new TreeSet();

        sortedSet2.add("a");
        sortedSet2.add("b");
        sortedSet2.add("c");
        sortedSet2.add("d");
        sortedSet2.add("e");

        SortedSet<String> headSet = sortedSet2.headSet("c"); // returns all elements "smaller" than "c"

        // Get TailSet.
        SortedSet<String> tailSet = sortedSet2.tailSet("a");

        // Get SubSet.
        SortedSet<String> subSet = sortedSet2.subSet("c", "e");
    }
}

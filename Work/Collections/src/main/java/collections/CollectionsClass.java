package collections;

import java.util.*;

public class CollectionsClass {
    public static void main(String[] args) {
        // 1. addAll() -> add a variable number of elements to a Collection
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "element 1", "element 2", "element 3");

        // 2. Perform binary search -> list must be sorted ascending prior.
        List<String> newList = new ArrayList<>();
        newList.add("one");
        newList.add("two");
        newList.add("three");
        newList.add("four");
        newList.add("five");

        Collections.sort(newList);

        int index = Collections.binarySearch(newList, "four");

        System.out.println(index);

        // 3. Copy all elements of a List into another List.
        List<String> source = new ArrayList<>();
        Collections.addAll(source, "e1", "e2", "e3");

        List<String> destination = new ArrayList<>(); // index out of bounds
        Collections.copy(destination, source);

        System.out.println(destination);

        Collections.reverse(list);

        Collections.shuffle(list);

        Collections.sort(list);

        // 4. Find the minimum/maximum according to the natural ordering.
        List<String> nrToString = new ArrayList<>();
        nrToString.add("1");
        nrToString.add("2");
        nrToString.add("3");

        String min = (String) Collections.min(nrToString);

        String max = (String) Collections.max(nrToString);

        // 5. Replace all occurrences of one element with another (returns true if at least one replaced).
        boolean replacedAny = Collections.replaceAll(source, "e1", "e4");

        // 6. Create an unmodifiable set (immutable) from a normal set.
        Set normalSet = new HashSet();

        Set immutableSet = Collections.unmodifiableSet(normalSet);
    }
}

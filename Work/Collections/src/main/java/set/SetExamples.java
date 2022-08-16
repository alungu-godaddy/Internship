package set;

import java.util.*;

public class SetExamples {
    public static void main(String[] args) {
        // 1. Create a set.
        Set setA = new HashSet();
        Set setB = new TreeSet();
        Set setC = new LinkedHashSet();

        // 2. Set static factory methods.
        Set set = Set.of(); // immutable set with no generic type.

        Set<String> set3 = Set.of("val1", "val2", "val3");

        // 3. Add element to set.
        Set<String> setD = new HashSet<>();

        setD.add("element 1");
        setD.add("element 2");
        setD.add("element 3");

        // 4. Iterate set using iterator.
        Iterator<String> iterator = setD.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();

            System.out.println(element);
        }

        // 5. Iterate using for-each loop.
        for (String element : setD) {
            System.out.println(element);
        }

        // 6. Iterate set using Java Stream API.
        setD.stream()
                .forEach((element) -> {
                    System.out.println(element);
                });

        setD.add("element x");
        // 7. Remove elements from set.
        setD.remove("element x");

        setD.clear(); // removes all elements

        // 8. Add elements from another collection.
        Set<String> setE = new HashSet<>();
        setE.add("one");
        setE.add("two");
        setE.add("three");

        Set<String> setF = new HashSet<>();
        setF.add("four");
        setF.addAll(setE);

        // 9. Remove all elements from another collection.
        setF.removeAll(setE);
    }
}

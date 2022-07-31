package collections;

import java.util.*;

public class Examples {
    public static void main(String[] args) {
        // 1. both collections will work calling doSomething.
        Set set = new HashSet();
        List list = new ArrayList();

        doSomething(set);
        doSomething(list);

        // 2. Add element to collection -> add(), no matter the collection.
        String anElement = "an element";
        Collection collection = new HashSet();

        boolean didCollectionChange = collection.add(anElement);
        System.out.println(didCollectionChange);

        // 3. Remove element from collection.
        boolean wasElementRemoved = collection.remove("an element");

        // 4. Add collection of objects to collection.
        Set aSet = new HashSet();
        aSet.add("Test");
        aSet.add("New element");
        collection.addAll(aSet);

        // 5. Remove collection of elements from collection.
        collection.removeAll(aSet);

        // 6. Retain all elements from a collection in another collection.
        Collection colA = new ArrayList();
        Collection colB = new ArrayList();

        colA.add("A");
        colA.add("B");
        colA.add("C");

        colB.add("1");
        colB.add("2");
        colB.add("3");

        Collection target = new HashSet();
        target.addAll(colA); // target now contains [A, B, C]
        target.addAll(colB); // target now contains [A, B, C, 1, 2, 3]

        target.retainAll(colB); // target now contains only [1, 2, 3]

        // 7. Checking if a collection contains a certain element.
        boolean containsElement = collection.contains("an element");
        boolean containsAll = collection.containsAll(target);

        // 8. Size of a collection.
        int numberOfElements = collection.size();

        // 9. Iterate a collection --> See iterable and iterator examples.
    }

    public static void doSomething(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();

            // do something with the object here
        }
    }
}

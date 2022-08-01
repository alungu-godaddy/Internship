package collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class GenericCollections {
    public static void main(String[] args) {
        // 1. Generic Collection Example.
        Collection<String> stringCollection = new HashSet<String>(); // redundant, i know

        // 2. Generic Iterator.
        Iterator<String> iterator = stringCollection.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            // do something with element.
        }

        // 3. Generic iteration using for loop.
        Collection<String> stringCollection1 = new HashSet<>();

        for (String stringElement : stringCollection1) {
            // do something with each stringElement
        }
    }
}

package iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ExceptionIterator {
    public static void main(String[] args) {
        // 3. Modification during iteration.

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();

            if (value.equals("456")) {
                try {
                    list.add("999"); // Raises ConcurrentModificationException
                } catch (ConcurrentModificationException ex)  {
                    ex.printStackTrace();
                }
            }
        }
    }
}

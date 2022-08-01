package list;

import java.util.*;

public class ListExamples {
    public static void main(String[] args) {
        // 1. Create a list.
        List listA = new ArrayList();
        List listB = new LinkedList();
        List listC = new Vector();
        List listD = new Stack();

        // 2. Generic lists.
        // Example: List<MyObject> list = new ArrayList<>();
        List<String> myList = new ArrayList<>();

        myList.add("Element 1");
        myList.add("Element 2");
        myList.add("Element 3");

        // 3. Insert null values.
        Object element = null;

        List<Object> objectList = new ArrayList<>();

        objectList.add(element);

        // 4. Insert element at specific index.
        myList.add(0, "Element 0"); // existing elements will get "pushed" further down

        // 5. Insert all elements from one list/set into another.
        List<String> listDest = new ArrayList<>();
        listDest.addAll(myList);

        // 6. Get elements from a java list.
        String element0 = myList.get(0);
        String element1 = myList.get(1);
        String element2 = myList.get(2);

        // 7. Find the index of the first occurrence.
        int index1 = myList.indexOf("Element 1");
        int index2 = myList.indexOf("Element 2");
        int index3 = myList.indexOf("Element 3");

        // 8. Find the last occurrence of element in list.
        int lastIndex = myList.lastIndexOf("Element 2");

        // 9. Checking if list contains element.
        boolean containsElement = myList.contains("Element 1");

        // 10. Remove elements from a Java list.
        myList.remove("Element 1");
        myList.remove(0);

        // 11. Remove all elements.
        myList.add("object 1");
        myList.add("object 2");

        myList.clear();

        // 12. Size.
        myList.add("object 1");
        myList.add("object 2");

        int size = myList.size();

        // 13. Sublist of list.
        myList.add("object 3");
        myList.add("object 4");

        List<String> sublist = myList.subList(1, 3); // object 2, 3, 4

        // 14. Convert list to set --> removes all duplicates in the initial list.
        Set<String> mySet = new HashSet<>();
        mySet.addAll(mySet);

        // 15. Convert List to Array.
        Object[] objects = myList.toArray();
        // or...
        String[] strings = myList.toArray(new String[0]);

        // 16. Convert Array to List.
        String[] values = new String[]{"one", "two", "three"};
        List<String> newList = Arrays.asList(values);

        // 17. Sort list of comparable objects.
        Collections.sort(myList);

        // 18. Sort list using comparator.
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Volvo V40", "XYZ 201845", 5));
        cars.add(new Car("Citroen C1", "ABC 164521", 4));
        cars.add(new Car("Dodge Ram", "KLM 845990", 2));

        Comparator<Car> carBrandComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.brand.compareTo(o2.brand);
            }
        };

        Collections.sort(cars, carBrandComparator);
    }
}

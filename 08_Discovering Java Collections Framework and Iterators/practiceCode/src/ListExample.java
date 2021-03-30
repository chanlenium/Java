//A program to (1) create list, (2) iterate through it, and (3) create a sublist.
//It uses removeIf() method with lambda expression to filter the list

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> strList = new LinkedList<>();
        // adding elements to the end
        strList.add("First");
        strList.add("Second");
        strList.add("Third");
        System.out.println(strList);    // [First, Second, Third]

        Iterator<String> it = strList.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        List<String> subList = strList.subList(1, 3);
        System.out.println(subList);    // [Second, Third]

        System.out.println("All strings in the list: " + strList);  // [First, Second, Third]
        strList.removeIf(e -> e.length() <= 5);
        System.out.println("After removing all strings with length <= 5 " + strList);   // [Second]
    }
}

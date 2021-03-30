//A program to print only distinct strings from the command line arguments of your program

import java.util.HashSet;
import java.util.Set;

public class FindDistinct {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        for(int i = 0; i < args.length; i++)
            if(!s.add(args[i])) // true when insert element is a new element
                System.out.println("Duplicate: " + args[i]);

            System.out.println(s.size() + " distinct arguments: " + s);
    }
}

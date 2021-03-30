package ComparingStudents;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlphabeticalStudents {
    public static void main(String args[]) {
        Student[] s = {
                new Student("John", "Savage"),
                new Student("Eric", "Marx"),
                new Student("Cuong", "Marx"),
                new Student("Oscar", "Savage"),
                new Student("Abe", "Vu")
        };

        List<Student> list = Arrays.asList(s);
        Collections.sort(list);
        //Sorts the specified list into ascending order, according to the natural ordering of its elements.
        System.out.println(list);
    }
}

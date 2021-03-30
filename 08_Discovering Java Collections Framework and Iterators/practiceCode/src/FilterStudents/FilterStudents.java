package FilterStudents;

import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterStudents {
    List<Student> myStudents = new ArrayList<>();
    // List : base class, ArrayList : extended class

    public FilterStudents(){
        myStudents.add(new Student("John", 55));
        myStudents.add(new Student("Mary", 75));
        myStudents.add(new Student("Wei", 80));
    }

    // when element with current index cannot satisfy condition, it is removed
    // but iterator still indicate right before the next element
    public void filter(Collection<Student> coll) {
        for (Iterator<Student> it = coll.iterator(); it.hasNext();)
            if (!cond(it.next()))
                it.remove();
    }

    // when element with current index cannot satisfy condition, it is removed
    // list size is reduced, and index i increases
    // so, next element ("Mary") is skipped
    public void wrongFilter(List<Student> coll) {
		for (int i = 0; i < coll.size(); i++) {
			if (!cond(coll.get(i))) {
				coll.remove(i);
			}
		}
	}

    private static boolean cond(Student s) {
        return (s.getMark() < 80) ? false : true;
    }

    public String toString(){
        return "Student who got more than or equal to 80: " + myStudents;
    }

    public static void main(String[] args) {
        FilterStudents filterStudents = new FilterStudents();
        filterStudents.filter(filterStudents.myStudents);
        //filterStudents.wrongFilter(filterStudents.myStudents);
        System.out.println(filterStudents);
    }
}

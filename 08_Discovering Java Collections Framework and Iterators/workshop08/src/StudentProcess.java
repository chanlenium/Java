import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProcess {

    // Comparator interface define comparison function (compare method)
    private static final Comparator<Student> STUDENT_ASCEND_ORDER = new Comparator<Student>() {
        @Override
        // compare two arguments for order
        public int compare(Student o1, Student o2) {
            int lastCmp = o1.getLastName().compareTo(o2.getLastName());
            return (lastCmp != 0 ? lastCmp : o1.getFirstName().compareTo(o2.getFirstName()));
        }
    };

    private static final Comparator<Student> STUDENT_DESCEND_ORDER = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            int lastCmp = -(o1.getLastName().compareTo(o2.getLastName()));
            return (lastCmp != 0 ? lastCmp : -(o1.getFirstName().compareTo(o2.getFirstName())));
        }
    };

    public static void main(String[] args) {
        // define input (Array of type Student)
        Student[] students = {
                new Student("Jack", "Smith", 50.0, "IT"),
                new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"),
                new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"),
                new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media")
        };

        System.out.println("Task 1:");
        System.out.println("Complete Student list:");
        List<Student> studentList = Arrays.asList(students);    // make a list out of array
        Iterator<Student> iterStudentList = studentList.iterator();
        while(iterStudentList.hasNext())
            System.out.println(iterStudentList.next());

        System.out.println("\nTask 2:");
        System.out.println("Students who got 50.0-100.0 sorted by grade:");
        Stream<Student> resultSteam = studentList.stream()  // make a stream out of list
                .filter(element -> element.getGrade() >= 50 && element.getGrade() <= 100)   // filter using lambda expression
                .sorted(Comparator.comparing(Student::getGrade));   // sort by student's grade
        resultSteam.forEach(System.out::println);   // print each filtered student

        System.out.println("\nTask 3:");
        System.out.println("First Student who got 50.0-100.0:");
        Student resultStudent = studentList.stream()
                .filter(element -> element.getGrade() >= 50 && element.getGrade() <= 100)
                .findFirst().orElse(null);  // find first element (or return null if no element satisfying condition)
        System.out.println(resultStudent);

        System.out.println("\nTask 4:");
        System.out.println("Students in ascending order by last name then first:");
        resultSteam = studentList.stream().sorted(STUDENT_ASCEND_ORDER);
        resultSteam.forEach(System.out::println);
        System.out.println("\nStudents in descending order by last name then first:");
        resultSteam = studentList.stream().sorted(STUDENT_DESCEND_ORDER);
        resultSteam.forEach(System.out::println);

        System.out.println("\nTask 5:");
        System.out.println("Unique Student last names:");
        Set<String> uniqueLastNames = new HashSet<>();
        studentList.stream().forEach(elem -> uniqueLastNames.add(elem.getLastName()));
        // add lastname into the map(uniques) if it is a new data
        uniqueLastNames.stream().sorted().forEach(System.out::println);

        System.out.println("\nTask 6:");
        System.out.println("Student names in order by last name then first name:");
        resultSteam = studentList.stream().sorted(STUDENT_ASCEND_ORDER);
        resultSteam.forEach(elem ->
                System.out.println(elem.getFirstName() + " " + elem.getLastName()));

        System.out.println("\nTask 7:");
        System.out.println("Students by department:");
        String[] keyArray = new String[]{"Media", "IT", "Business"};
        Map<String, List<Student>> mapByDepartment = new HashMap<>();
        Arrays.stream(keyArray).forEach(keyElem ->
                mapByDepartment.put(keyElem, studentList.stream()
                        .filter(elem -> elem.getDepartment().equals(keyElem))
                        .collect(Collectors.toList())));
        // Map.Entry could be used for iterating over key-value pairs
        for (Map.Entry<String, List<Student>> e : mapByDepartment.entrySet()) {
            System.out.println(e.getKey()); // print key
            Iterator<Student> iterStudent = e.getValue().iterator();
            while(iterStudent.hasNext())    // print value
                System.out.println("     " + iterStudent.next());
        }

        System.out.println("\nTask 8:");
        System.out.println("Count of Students by department:");
        Map<String, Long> mapStudentCount = new HashMap<>();
        for (Student student : studentList) {
            Long returnVal = mapStudentCount.get(student.getDepartment());   // return value corresponding to key
            mapStudentCount.put(student.getDepartment(), ((returnVal == null) ? 1 : returnVal + 1)); // put key-value pair
        }
        for (Map.Entry<String, Long> e : mapStudentCount.entrySet())
            System.out.println(e.getKey() + " has " + e.getValue() + " Student(s)");

        System.out.println("\nTask 9:");
        double sum = studentList.stream()
        .mapToDouble(elem -> Double.parseDouble(String.valueOf(elem.getGrade()))).sum();
        System.out.println("Sum of Students' grades: " + sum);

        System.out.println("\nTask 10:");
        OptionalDouble avg = studentList.stream()
                .mapToDouble(elem -> elem.getGrade()).average();
        System.out.println(String.format("Average of Students' grades: %.2f", avg.getAsDouble()));
    }
}

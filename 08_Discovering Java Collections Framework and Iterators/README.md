# Workshop 08 : Java Collections Framework

## Objectives
* Practice functional programming as the new paradigm of programming to write programs more concise
* Implement collection framework using Generics, Functional Interfaces, Lambda Expressions, Method References, Streams, and Collections

## Outline
### Define a Student class
```
public class Student{
    private String firstName;
    private String lastName;
    private double grade;
    private String department;
    // Costructor
    // getter and setter
    // Override toString method 
}
```
### Implement StudentProcess class
* Task1 : Create Student list using `Iterator`
```
List<Student> studentList = Arrays.asList(students);    // make a list out of array
Iterator<Student> iterStudentList = studentList.iterator();
while(iterStudentList.hasNext())
    System.out.println(iterStudentList.next());
```

* Task2 : Sort students who got 50.0-100.0 by grade
```
Stream<Student> resultSteam = studentList.stream()  // make a stream out of list
        .filter(element -> element.getGrade() >= 50 && element.getGrade() <= 100)   // filter using lambda expression
        .sorted(Comparator.comparing(Student::getGrade));   // sort by student's grade
resultSteam.forEach(System.out::println);   // print each filtered student
```

* Task3 : Select the First Student who got 50.0-100.0
```
Student resultStudent = studentList.stream()
        .filter(element -> element.getGrade() >= 50 && element.getGrade() <= 100)
        .findFirst().orElse(null);  // find first element (or return null if no element satisfying condition)
System.out.println(resultStudent);
```

* Task4 : List students in ascending order by last name then first
```
resultSteam = studentList.stream().sorted(STUDENT_ASCEND_ORDER);
resultSteam.forEach(System.out::println);
System.out.println("\nStudents in descending order by last name then first:");
resultSteam = studentList.stream().sorted(STUDENT_DESCEND_ORDER);
resultSteam.forEach(System.out::println);
```

* Task5 : Make `Set` based on last names
```
Set<String> uniqueLastNames = new HashSet<>();
studentList.stream().forEach(elem -> uniqueLastNames.add(elem.getLastName()));
// add lastname into the map(uniques) if it is a new data
uniqueLastNames.stream().sorted().forEach(System.out::println);
```

* Task6 : List student names in order by last name then first name
```
resultSteam = studentList.stream().sorted(STUDENT_ASCEND_ORDER);
resultSteam.forEach(elem ->
        System.out.println(elem.getFirstName() + " " + elem.getLastName()));
```

* Task7 : List students by department
```
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
```

* Task8 : Count of Students by department using `Map`
```
Map<String, Long> mapStudentCount = new HashMap<>();
for (Student student : studentList) {
    Long returnVal = mapStudentCount.get(student.getDepartment());   // return value corresponding to key
    mapStudentCount.put(student.getDepartment(), ((returnVal == null) ? 1 : returnVal + 1)); // put key-value pair
}
for (Map.Entry<String, Long> e : mapStudentCount.entrySet())
    System.out.println(e.getKey() + " has " + e.getValue() + " Student(s)");
```

* Task9 : Caculate sum of Students' grades
```
double sum = studentList.stream().mapToDouble(elem -> Double.parseDouble(String.valueOf(elem.getGrade()))).sum();
System.out.println("Sum of Students' grades: " + sum);
```

* Task10 : Calculate average of Students' grades
```
OptionalDouble avg = studentList.stream()
        .mapToDouble(elem -> elem.getGrade()).average();
System.out.println(String.format("Average of Students' grades: %.2f", avg.getAsDouble()));
```


## Screenshot
* Link : https://github.com/chanlenium/Java/blob/main/08_Discovering%20Java%20Collections%20Framework%20and%20Iterators/workshop08/Screenshot.pdf

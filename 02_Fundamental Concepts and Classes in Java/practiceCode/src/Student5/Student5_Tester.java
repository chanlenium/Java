package Student5;

import Student1.Student1;

public class Student5_Tester { //has package access to Student5 because they are in the same folder!
    public static void printInfo(Student5 student){
        System.out.println("ID: " + student.getId());
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("No. of Student objects in memory so far: " + student.getCount());
    }

    public static void main(String[] args){
        // This class has access to class Student5 and could create obj.s ...
        Student5 student1 = new Student5();
        Student5 student2 = new Student5(2, "John", "White");

        System.out.println("Student1's info: ");
        printInfo(student1);

        System.out.println("Student2's info: ");
        printInfo(student2);
    }
}

// What's the problem?!
// Each object has its own space for its instance, so student1 and student2 have its own variable "count"
// i.e., variable "count" is not shared between student1 and student2

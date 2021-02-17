package Student6;

public class Student6_Tester {//has package access to Student6 because they are in the same folder!

    // the method called from main() should be declared as "static"
    // because main() method is declared as "static"
    public static void printInfo(Student6 student) {
        System.out.println("ID: " + student.getId());
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
    }

    // The reason why main() is declared as "static"
    // When a program runs, there is no Class object.
    // So, to access the main() method, main() should be declared as "static"
    // i.e., When a program runs, CLASSNAME.main() is called.
    public static void main(String[] args) {
        //This class has access to class Student6 and could create obj.s ...
        Student6 student1 = new Student6();
        Student6 student2 = new Student6(2, "John", "White");

        System.out.println("student1's info: ");
        printInfo(student1);

        System.out.println("\nstudent2's info: ");
        printInfo(student2);

        System.out.println("\nNo. of Student objects in memory so far: " + student1.getCount());//OR student2.getCount()
        //OR even better to say: "System.out.println("No. of Student objects in memory so far: " + Student6.getCount());"
    }
}

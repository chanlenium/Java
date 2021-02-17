package Student4;

public class Student4_Tester {  //has package access to Student4 because they are in the same folder!
    // Method (like member function in C++)
    public static void printInfo(Student4 student){
        System.out.println("ID: " + student.getId());
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
    }

    public static void main(String[] args) {
        Student4 student1 = new Student4();
        Student4 student2 = new Student4(2, "John", "White");
        Student4 student3 = new Student4(student1); // Copy constructor
        Student4 student4 = new Student4(4);

        System.out.println("Student1's Info: ");
        printInfo(student1);

        System.out.println("Student2's Info: ");
        printInfo(student2);

        System.out.println("Student3's Info: ");
        printInfo(student3);

        System.out.println("Student4's Info: ");
        printInfo(student4);

        student3.setStudent(3, "James", "Brown");
        System.out.println("Student3's Info: ");
        printInfo(student3);

        System.out.println("Student4's Info again: ");
        printInfo(student4.getStudent());
    }
}

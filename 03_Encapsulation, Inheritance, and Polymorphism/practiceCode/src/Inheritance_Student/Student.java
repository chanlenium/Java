package Inheritance_Student;

// Provide a no-argument constructor
// Constructors are not inherited but are called from subclass constructor using "super()"
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    // setter and getters needed


    public Student(long id, String firstName, String lastName) {
        super(); // It happens even if you don't say it!
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
        // no-arg Constructor
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Dongchan", "Oh");
        System.out.println(student1.id);
        System.out.println(student1.firstName);
        System.out.println(student1.lastName);
    }
}

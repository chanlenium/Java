package Student3;

public class Student3 {
    private long id;
    private String firstName;
    private String lastName;

    // no-argument constructor
    // If there is no-argument constructor, default constructor does not exist any more
    public Student3() {
        id = 1;
        firstName = "Dongchan";
        lastName = "Oh";
    }

    // We "could" give access to other classes using setters/getters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        // "this.fieldName" format is used to set the value of field
        this.id = id;
        // Also note that in many cases in industry, we need to having checkings inside the setters.
        // (i.e., parameter validation)
        // if(id <= 0)
        //     return;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        //Using the above no-argument constructor
        Student3 student1 = new Student3();

        System.out.println(student1.id);
        System.out.println(student1.firstName);
        System.out.println(student1.lastName);

        // Even in the same Class, it is more secure to access fields using getter
        System.out.println(student1.getId());
        System.out.println(student1.getFirstName());
        System.out.println(student1.getLastName());
    }
}

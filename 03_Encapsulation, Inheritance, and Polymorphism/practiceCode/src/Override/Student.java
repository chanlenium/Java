package Override;

//Override equals() and toString() methods (from class Object), whenever possible
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    //setters and getters needed

    public Student(long id, String firstName, String lastName) {
        super();//it happens even if you don't say it!
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("This is %s %s with StID: %d", firstName, lastName, id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null)
            return false;

        if(getClass() != obj.getClass())    // getClass() : return runtime Class
            return false;

        Student other = (Student) obj;

        if(id != other.id)  // after downcasting at line 33, object can access to the field "id"
            return false;

        if(firstName == null){
            if(other.firstName != null)
                return false;
        }else if(!firstName.equals(other.firstName))
            return false;

        if(lastName == null){
            if(other.lastName != null)
                return false;
        }else if(!lastName.equals(other.lastName))
            return false;

        return true;
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Dongchan", "Oh");
        Student student2 = new Student(1, "Dongchan", "Oh");

        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));

        System.out.println(student1.toString());
        System.out.println(student2);   // Implicitly print as a String
    }
}

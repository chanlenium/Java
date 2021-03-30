package ComparingStudents;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName){
        if(firstName == null || lastName == null){
            throw new NullPointerException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString(){
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Student o) {
        int lastCmp = lastName.compareTo(o.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(o.firstName));
    }
}

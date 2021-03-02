import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int stdId;  // field for student ID
    private String firstName;   // field for first name of student
    private String lastName;    // field for last name of student
    private ArrayList<String> courses;  // ArrayList for storing course name the student takes

    // Full constructor
    public Student(int stdId, String firstName, String lastName, ArrayList<String> courses) throws InputException{
        if(stdId > 0 && firstName != null && lastName != null && courses.size() > 0){
            this.stdId = stdId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.courses = courses;
        }else{
            // If an input is invalid, throw the exception!
            throw new InputException("Invalid user input!");
        }
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
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

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        String result;
        result = "\nName: " + this.firstName + " " + this.lastName
                + "\nStudent ID: " + this.stdId
                + "\nCourses: " + this.courses;
        return result;
    }
}

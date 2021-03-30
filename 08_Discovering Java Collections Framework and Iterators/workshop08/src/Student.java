import java.util.Comparator;

public class Student{
    private String firstName;
    private String lastName;
    private double grade;
    private String department;

    public Student(String firstName, String lastName, double grade, String department) {
        if(firstName == null || lastName == null || department == null)
            throw new NullPointerException();

        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.department = department;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName(){
        return getFirstName() + getLastName();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("%-10s", getFirstName())
                + String.format("%-10s", getLastName())
                + String.format("%-10.2f", getGrade())
                + String.format("%-10s", getDepartment());
    }
}

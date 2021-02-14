package exceptionTest;

public class StudentManager {
    public Student find(String studentID) throws StudentNotFoundException {
        if (studentID.equals("123456")) {
            return new Student();
        } else {
            throw new StudentNotFoundException(
                    "Could not find student with ID " + studentID);
        }
    }
}

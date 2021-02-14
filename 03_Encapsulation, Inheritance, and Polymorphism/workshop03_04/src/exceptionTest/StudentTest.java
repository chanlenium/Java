package exceptionTest;

public class StudentTest {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        try {

            Student student = manager.find("0000001");

        } catch (StudentNotFoundException ex) {
            System.err.print(ex);
        }
    }
}

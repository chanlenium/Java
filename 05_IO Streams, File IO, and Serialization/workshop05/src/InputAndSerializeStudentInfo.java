import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class InputAndSerializeStudentInfo {
    // final variable to set input range(MIN~MAX)
    static final int MIN_STD_ID = 0, MAX_STD_ID = 99999;
    static final int MIN_COURSE_NO = 0, MAX_COURSE_NO = 10;

    private static String pattern;  // variable for pattern used to validate user input

    private static int stdID;
    private static int numberOfCourses;
    private static String firstName, lastName, courseName;
    private static ArrayList<String> courses = new ArrayList<String>();
    private static Student student;

    public static void main(String[] args) {
        // Input data from console
        System.out.print("Enter a student ID (" + MIN_STD_ID + "-" + MAX_STD_ID + "): ");
        stdID = new Utils().enterInteger(MIN_STD_ID, MAX_STD_ID);

        System.out.print("Enter a student's first Name: ");
        pattern = "[A-Za-z]*";
        firstName = new Utils().enterString(pattern);

        System.out.print("Enter a student's last Name: ");
        lastName = new Utils().enterString(pattern);

        System.out.print("Enter the number of courses the student takes: ");
        numberOfCourses = new Utils().enterInteger(MIN_COURSE_NO, MAX_COURSE_NO);
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.print("Enter the name of " + (i + 1) + "-th course: ");
            pattern = "[A-Za-z0-9]*";
            courseName = new Utils().enterString(pattern);
            courses.add(courseName);
        }

        // save input data in Student object
        try {
            // construct the student object using 4 parameters
            student = new Student(stdID, firstName, lastName, courses);
        } catch (InputException e) {    // catch and treat exception
            System.err.println(e.getMessage());
        }

        // save student object in a file (Serial)
        try{
            FileOutputStream fos = new FileOutputStream("output.txt");
            // OjbectOutputStream acts as a bridge to link "Student" object and "output.txt"
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.flush();    // This thing happens right now
            fos.close();
            // System.out.println(student.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

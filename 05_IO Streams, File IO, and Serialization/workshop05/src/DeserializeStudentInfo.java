import java.io.*;

public class DeserializeStudentInfo {
    public static void main(String[] args) {
        Student student = null;
        try {
            FileInputStream fis = new FileInputStream("output.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            student = (Student) ois.readObject();   // to access inside that one
            // When doing Deserialization, whole object in the memory is read
            // so, security issue might be happened
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Deserialization--readObject");
        System.out.println(student.toString());
    }
}

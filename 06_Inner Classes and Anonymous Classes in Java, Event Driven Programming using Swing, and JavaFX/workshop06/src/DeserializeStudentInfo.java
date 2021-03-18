import java.io.*;

public class DeserializeStudentInfo {
    private String deserializedString;

    public String deserialize() {
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
        deserializedString = student.toString();

        return deserializedString;
    }
}

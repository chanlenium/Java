import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestDeserial {
    public static void main(String[] args) {
        Test testObj = null;
        try{
            FileInputStream fis = new FileInputStream("fileout.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            testObj = (Test)ois.readObject();   // to access inside that one
            // When doing Deserialization, whole object in the memory is read
            // security issue might be happened

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Deserialization--readObject string: " + testObj.getString());
        System.out.println("Deserialization--readObject int: " + testObj.getInt());
    }
}

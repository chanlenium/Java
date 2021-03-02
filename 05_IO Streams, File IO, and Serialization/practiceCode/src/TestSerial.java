import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestSerial {
    public static void main(String[] args) {
        Test anObj = new Test("This is a testing string for serialization", 777);
        try{
            FileOutputStream fos = new FileOutputStream("fileout.txt");
            // OjbectOutputStream acts as bridge to link "anObj" and "file.out"
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(anObj);
            oos.flush();    // This thing happens right now
            fos.close();

            System.out.println("Serialization--writeObject string: " + anObj.getString());
            System.out.println("Serialization--writeObject int: " + anObj.getInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

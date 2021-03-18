import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;

public class SerializeStudentInfo {
    public void serialize(Student student) {
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

    public boolean enterInteger(String str, int min, int max) {
        boolean result;
        try {
            Integer.parseInt(str);
            result = true;
        } catch (NumberFormatException e) {
            System.err.println("Input is invalid. Enter only numbers");
            result = false;
        }
        return result;
    }

    public boolean enterName(String str, String pattern) {
        return Pattern.matches(pattern, str);
    }

    public boolean enterCourseName(String[] str, String pattern) {
        boolean result = false;
        if(str.length > 0){
            for(int i = 0; i < str.length; i++) {
                // Check whether an input matches pattern
                if(!Pattern.matches(pattern, str[i].trim()) || !(str[i].trim().length() == 6)){
                    result = false;
                    break;
                }else{
                    result = true;
                }
            }
        }
        return result;
    }
}

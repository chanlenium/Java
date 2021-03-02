import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
    public static void main(String[] args) {
        BufferedReader d = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        try{
            while((s = d.readLine()).length() != 0)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

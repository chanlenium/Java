import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountBytes {
    public static void main(String[] args) throws IOException {
        InputStream in;

        // If there is no argument, receive the input using console keyborad
        if(args.length == 0)
            in = System.in;
        else
            in = new FileInputStream(args[0]);

        int total = 0;
        while(in.read() != -1)
            total++;    // If program receive input in ASCII code, it allocates 1 byte space

        System.out.println(total + " bytes");
    }
}

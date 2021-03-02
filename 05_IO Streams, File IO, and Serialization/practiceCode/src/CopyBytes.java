import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        // Check the number of input is 2 or more
        // If not, the process finished with exit code 0
        if(args.length < 2)
            return;

        // Byte based stream : raw level 단위로 read/write (conversion하지 않음)
        // class name ends with 'Stream'
        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream(args[0]);
            out = new FileOutputStream(args[1]);
            int c;  // reference variable for return value

            // in.read() : Read input by 'byte' unit and return 'int' value
            // Since int is 4-bytes size, the first 3 bytes are set to all zero
            // If EOF, it returns '-1' which is all '1' in two's compliment system (11111111)
            while((c=in.read()) != -1){
                // Skip the first 3 bytes, and write last byte value
                out.write(c);
            }
        }finally {
            // File close to avoid memory leak
            if(in != null)
                in.close();
            if(out != null)
                out.close();
        }
    }
}

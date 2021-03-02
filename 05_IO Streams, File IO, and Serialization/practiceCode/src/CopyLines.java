import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        // BufferReader is a Buffer for reading from IO
        // It reads all characters at one time and store them in buffer(memory)
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        
        try{
            // Create input stream using "new FileReader(args[0])" which inherits from Reader class
            inputStream = new BufferedReader(new FileReader(args[0]));
            outputStream = new PrintWriter(new FileWriter(args[1]));

            String l;
            // Read characters from a buffer
            while((l = inputStream.readLine()) != null){
                outputStream.println(l);
            }
        }finally {
            if(inputStream != null)
                inputStream.close();
            if(outputStream != null)
                outputStream.close();
        }
        
    }
}

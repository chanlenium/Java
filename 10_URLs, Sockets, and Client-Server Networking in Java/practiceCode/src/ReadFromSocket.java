import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadFromSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7777);
            /**
             * If there is no server using port number 7777, Connection is refused
             * So, the server using dedicated port number should be created in advance.
             */
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String theLine = bufferedReader.readLine();
            System.out.println(theLine);

            socket.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
    }
}

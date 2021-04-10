import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer {
    public static void main(String[] args) throws IOException {
        System.out.println("EchoServer started");

        ServerSocket s = null;
        try {
            s = new ServerSocket(7777);
            int i = 0;
            for(;;){
                Socket incoming = s.accept();  // wait until clients come
                System.out.println("Spawning " + ++i);
                // Generate and start new thread
                new ThreadedEchoHandler(incoming, i).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}

class ThreadedEchoHandler extends Thread{
    private Socket incoming;
    private int clientNumber;

    public ThreadedEchoHandler(Socket s, int c){
        incoming = s;
        clientNumber = c;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
            out.println("Hello! Enter BYE to exit");
            boolean done = false;
            while(!done){
                String str = in.readLine();
                if(str == null)
                    done = true;
                else{
                    out.println("Echo (" + clientNumber + "): " + str);
                    System.out.println("Received from (" + clientNumber + "): " + str);
                    if(str.trim().equals("BYE"))
                        done = true;
                }
            }
            incoming.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

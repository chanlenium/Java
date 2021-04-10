/**
 * Execute EchoServer.java(@Server) first, then execute ReadFromSocket.java(@Client)
 * or execute Telnet => telnet localhost 7777
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("EchoServer started");

        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            /**
             * wait until client comes..
             * When any clients try to connect, it returns an object with socket type
             */
            Socket clientSocket = serverSocket.accept();

            System.out.println("Connected to port : " + clientSocket.getLocalPort());

            // object to read stream from client input
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // object to write stream to server for client to read
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            out.println("Hello! This is Java Echo Server. Enter BYE to exit");  // write on server
            out.flush();

            for(;;){
                String str = in.readLine();

                if(str == null){
                    break;
                }else{
                    // write (send) back to the client whatever was received
                    // adding the Echo string in front of it
                    out.println("Echo: " + str);
                    out.flush();
                    System.out.println("Received from Client: " + str);

                    if(str.trim().equals("BYE"))
                        break;
                }
            }

            clientSocket.close();
            serverSocket.close();
            /** Problem!!
             * When client socket close, the server also close
             * => MultiThread is a solution!!
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Echo Server stopped");
    }
}

package RMIHello;

import java.rmi.Naming;
import java.util.Scanner;

public class HelloClient {
    // "obj" is the identifier that we will use to refer
    // to the remote object that implements the "Hello" interface
    Hello obj = null;

    public String action(int input){
        String message = null;
        try{
            // Client just needs to know "interface" and "service name (in here, HelloService)"
            obj = (Hello) Naming.lookup("rmi://localhost:1098/HelloService");
            message = obj.sayHello(input);
        }catch(Exception e){
            System.out.println("Hello Client Exception: " + e.getMessage());
        }
        return message;
    }

    public static void main(String[] args) {
        HelloClient helloClient = new HelloClient();
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("Type a number (0-3) : ");
            int in = input.nextInt();
            if(in != 0){
                System.out.println("Message from Server: " + helloClient.action(in));
            }else{
                break;
            }
        }
        input.close();
    }
}

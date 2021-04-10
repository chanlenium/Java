import java.net.InetAddress;
import java.net.UnknownHostException;

public class Local {
    public static void main(String[] args) {
        try {
            // InetAddress class represents an Internet Protocol (IP) address
            InetAddress myLocalHostAddress = InetAddress.getLocalHost();
            System.out.println("My host name is: " + myLocalHostAddress.getHostName());
            System.out.println("My host IP address is: " + myLocalHostAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Could not determine local address.");
            e.printStackTrace();
        }

    }
}

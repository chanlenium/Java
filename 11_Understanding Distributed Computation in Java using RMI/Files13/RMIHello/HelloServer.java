//RMI Server
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
	public static void main(String args[]) {
		try {
			// Create the object implemtation
			Hello obj = new HelloImpl();

			// Bind this object instance to the name "HelloService"
			// Remember to run rmiregistry first!
			Naming.rebind("rmi://localhost:1099/HelloService", obj);
			
			// And here's the second solution (without the need of running rmiregistry)
//			Registry registry = LocateRegistry.createRegistry(1099);
//			registry.rebind("HelloService", obj);

			System.out.println("HelloService bound in registry");
			System.out.println("HelloService is running");
		} catch (Exception e) {
			System.err.println("Problem: " + e);
			System.exit(1);
		}
	}
}
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {

	public CalculatorServer() {
		try {			
			// Create the object implemtation
			Calculator obj = new CalculatorImpl();
			
			// Bind this object instance to the name "CalculatorService"
			// Remember to run rmiregistry first!
			Naming.rebind("rmi://localhost:1099/CalculatorService", obj);
			
			// And here's the second solution (without the need of running rmiregistry)
//			Registry registry = LocateRegistry.createRegistry(1099);
//			registry.rebind("CalculatorService", obj);
			
			System.out.println("CalculatorService bound in registry");			
		} catch (Exception e) {
			System.err.println("Problem: " + e);
			System.exit(1);
		}
	}

	public static void main(String args[]) {
		new CalculatorServer();
		System.out.println("CalculatorService is running");
	}
}

//RMI Service Implementation
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {
	
	// Implementations must have an explicit constructor
	// in order to declare the RemoteException exception
	public HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello(int time) throws RemoteException {
		switch (time) {
		case 1:
			return "Good morning!";
		case 2:
			return "Good afternoon!";
		case 3:
			return "Good evening!";
		default:
			return "Good day!";
		}
	}
}
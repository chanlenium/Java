// Step2
// Develop Java code implementing classes defined by RMI interface
// implement a method in interface by a remote Java virtual machine

package RMIHello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImplement extends UnicastRemoteObject implements Hello {
    // Implementations must have an explicit constructor
    // in order to declare the RemoteException exception
    // Super class "UnicastRemoteObject"에서 RemoteException을 throw하므로,
    // subclass에서도 throws RemoteException하여 예외 처리를 할 수 있도록 해야 함
    protected HelloImplement() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(int timeOfDay) throws RemoteException {
        switch(timeOfDay){
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

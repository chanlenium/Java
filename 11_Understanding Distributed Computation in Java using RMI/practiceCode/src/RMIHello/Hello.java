// Step1 : RMI Interface definitions for remote services
// RMI interface (define behavior)
// Remote interface is an interface that declares a set of methods that may be implemented by a remote Java virtual machine:
package RMIHello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello(int timeOfDay) throws RemoteException;
}

/**
 * Execution way
 * (1) open folder where all java files are located
 * (2) press "Alt + F + R" (open powershell)
 * (3) type "rmiregistry"
 * (4) run HelloServer
 * (5) run HelloClient
 */

package RMICalculator;

//Interface defines all of the remote features offered by the server
public interface Calculator extends java.rmi.Remote {

    long add(long a, long b)
            throws java.rmi.RemoteException;

    long sub(long a, long b)
            throws java.rmi.RemoteException;

    long mul(long a, long b)
            throws java.rmi.RemoteException;

    long div(long a, long b)
            throws java.rmi.RemoteException;
}


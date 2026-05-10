package pr02;

// Import RMI classes
import java.rmi.*;

// Import server classes for remote object
import java.rmi.server.*;

// Implementation class
// extends UnicastRemoteObject makes object remotely accessible
// implements AddServerIntf implements remote methods
public class AddServerImpl extends UnicastRemoteObject
implements AddServerIntf {

    // Constructor
    // throws RemoteException handles network-related errors
    public AddServerImpl() throws RemoteException {

        // Call parent class constructor
        super();
    }

    // Remote method implementation
    // This method will be called by client remotely
    public double add(double a, double b)
            throws RemoteException {

        // Return addition of two numbers
        return a + b;
    }
}
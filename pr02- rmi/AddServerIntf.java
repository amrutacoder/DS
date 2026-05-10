package pr02;

// Import RMI classes
import java.rmi.*;

// Remote interface
// extends Remote allows methods to be accessed remotely
public interface AddServerIntf extends Remote {

    // Remote method declaration
    // Takes two numbers and returns addition result

    // throws RemoteException handles network-related errors
    double add(double a, double b)
    throws RemoteException;
}

/*-- how to ru n--
put requires java.rmi in module-info
1st terminal
cd "/c/8th Sem/DS/Amruta/pr02/src"
compile all Java files
javac pr02/*.ja	va
OR compile one by one:
javac pr02/AddServerIntf.java
javac pr02/AddServerImpl.java
javac pr02/AddServer.java
javac pr02/AddClient.java

2nd terminal
cd....
rmiregistry

3rd - Run Server:
java pr02.AddServer

4th -Run Client:
java pr02.AddClient 10 20

RMI = Remote Method Invocation
It is a Java technology that allows:
one Java program to call methods of another Java program running on different machine/system.

*/

package pr02;

// Import RMI classes
import java.rmi.*;

// Server class
public class AddServer {

    // Main method - execution starts here
    public static void main(String[] args) {

        try {

            // Create object of implementation class
            // This object contains add() method
            AddServerImpl obj =
                    new AddServerImpl();

            // Register remote object with RMI registry
            // "AddServer" is object name used by client
            Naming.rebind("AddServer", obj);

            // Display server started message
            System.out.println("Server Started");

        }

        // Handle exceptions/errors
        catch (Exception e) {

            // Print error message
            System.out.println(e);
        }
    }
}
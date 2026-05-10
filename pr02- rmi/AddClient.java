package pr02;

// Import RMI classes
import java.rmi.*;

// Client class
public class AddClient {

    // Main method - execution starts here
    public static void main(String[] args) {

        try {

            // Lookup remote object from RMI registry
            // localhost means same computer
            // AddServer is registered object name
            AddServerIntf addObj =
            (AddServerIntf) Naming.lookup(
                    "rmi://localhost/AddServer");

            // Take first number from command line
            // Convert string into double
            double num1 =
            Double.parseDouble(args[0]);

            // Take second number from command line
            // Convert string into double
            double num2 =
            Double.parseDouble(args[1]);

            // Call remote add() method
            // Server performs addition
            double result =
            addObj.add(num1, num2);

            // Print final result
            System.out.println(
                    "Addition Result = " + result);

        }

        // Handle exceptions/errors
        catch (Exception e) {

            // Print error message
            System.out.println(e);
        }
    }
}
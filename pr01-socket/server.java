package pr01;

// Import classes for input-output operations
import java.io.*;

// Import classes for networking
import java.net.*;

// Server class
public class server {

    // Main method - execution starts from here
    public static void main(String[] args) {

        try {

            // Create server socket on port number 5000
            ServerSocket ss = new ServerSocket(5000);

            // Display message that server is waiting
            System.out.println("Server is waiting for client...");

            // Accept client connection
            // Program waits here until client connects
            Socket s = ss.accept();

            // Display connection successful message
            System.out.println("Client connected!");

            // Create BufferedReader to receive message from client
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            // Create PrintWriter to send message to client
            PrintWriter pw = new PrintWriter(
                    s.getOutputStream(), true);

            // Read message sent by client
            String msg = br.readLine();

            // Print client message on server screen
            System.out.println("Client says: " + msg);

            // Send reply message to client
            pw.println("Hello Client, Message Received!");

            // Close client socket connection
            s.close();

            // Close server socket
            ss.close();

        }

        // Handle exceptions/errors
        catch (Exception e) {

            // Print error message
            System.out.println(e);
        }
    }
}
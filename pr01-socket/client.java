package pr01;

// Import classes for input-output operations
import java.io.*;

// Import classes for networking
import java.net.*;

// Client class
public class client {

    // Main method - execution starts from here
    public static void main(String[] args) {

        try {

            // Create socket and connect to server
            // localhost means same computer
            // 5000 is port number
            Socket s = new Socket("localhost",5000);

            // Create PrintWriter object to send message to server
            PrintWriter pw = new PrintWriter(
                    s.getOutputStream(), true);

            // Create BufferedReader object to receive message from server
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            // Send message to server
            pw.println("Hello Server");

            // Read message coming from server and print it
            System.out.println(br.readLine());

            // Close socket connection
            s.close();

        }

        // Handle exceptions/errors
        catch(Exception e) {

            // Print error message
            System.out.println(e);
        }
    }
}

/*
Compile both separately - javac Server.java , javac Client.java 
Run server first - java Server 
Run client - java Client 
Watch output 
*/
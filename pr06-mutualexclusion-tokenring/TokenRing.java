package pr06;

import java.util.Scanner;
public class TokenRing {

    public static void main(String[] args) throws InterruptedException {
    	 	//InterruptedException is an exception that occurs when a thread is interrupted while it is sleeping or waiting.

        // Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Input number of processes in the ring
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        // Input initial token holder (which process has token first)
        System.out.print("Enter initial token holder: ");
        int token = sc.nextInt();

        // Input requesting process (wants to enter critical section)
        System.out.print("Enter requesting process: ");
        int req = sc.nextInt();

        System.out.println("\nProcess P" + req + " wants Critical Section\n");

        // Pass token until it reaches requesting process
        while (token != req) {

            // Show token movement from current process to next process
            System.out.println("Token at P" + token +
                    " - passing to P" + (token + 1) % n);

            // Move token to next process in circular manner
            token = (token + 1) % n;
        }

        // Critical Section starts here
        System.out.println("P" + token + " ENTERED Critical Section");

        // Simulate execution time inside critical section
        Thread.sleep(500);

        // Critical Section ends here
        System.out.println("P" + token + " EXITED Critical Section\n");

        // Store starting position after critical section
        int start = token;

        System.out.println("Token continues circulating...\n");

        // Continue token circulation in ring after execution
        do {
            System.out.println("Token at P" + token +
                    " - passing to P" + (token + 1) % n);

            // Move token forward
            token = (token + 1) % n;

        } while (token != start); // stop when full cycle completes

        // Close scanner resource
        sc.close();
    }
}

/*Token Ring Algorithm idea:
•	All processes are arranged in a ring (circle) 
•	A special message called TOKEN circulates in the ring 
•	Only the process holding the TOKEN can enter the critical section 
•	After finishing, it passes the TOKEN to the next process 
“Whoever has the token gets permission to use the resource.”
Why we use (token + 1) % n?

This is used to move the token to the next process in a circular way.
*/
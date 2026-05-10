import java.util.*;

public class Berkely {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of nodes in distributed system
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Array to store clock time of each node
        int[] time = new int[n];

        int sum = 0;

        // ---------------- INPUT SECTION ----------------
        // Take time from each node
        for (int i = 0; i < n; i++) {

            System.out.print("Enter time for node " + i + ": ");
            time[i] = sc.nextInt();

            sum += time[i]; // calculate total time
        }

        // ---------------- AVERAGE CALCULATION ----------------
        int avg = sum / n;

        System.out.println("\nAverage time = " + avg);

        // ---------------- CLOCK ADJUSTMENT ----------------
        System.out.println("\nTime adjustments:");

        for (int i = 0; i < n; i++) {

            // difference between average and current time
            int diff = avg - time[i];

            System.out.println("Node " + i + " adjust by: " + diff);

            // update node time
            time[i] += diff;
        }

        // ---------------- FINAL SYNCHRONIZED TIME ----------------
        System.out.println("\nSynchronized times:");

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + ": " + time[i]);
        }

        sc.close();
    }
}
/*Assignment 5: Clock Synchronization
Berkeley Algorithm for Clock Synchronization
What is Clock Synchronization?
In distributed systems:
👉 Every computer has its own clock
👉 But clocks are NOT perfectly same
👉 So time may differ in each node
Node A → 10:00  
Node B → 10:05  
Node C → 09:58
👉 All show different time ❌
👉 This creates confusion in system
________________________________________
🟢 Solution → Berkeley Algorithm
👉 It is used to synchronize all clocks to a common time
________________________________________
🧠 Main Idea
✔ One node becomes Master (Coordinator)
✔ It collects time from all nodes
✔ It calculates average time
✔ It sends correction to all nodes
*/
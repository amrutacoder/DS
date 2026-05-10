import java.util.Scanner;

public class Ring {

    public static void main(String[] args) {

        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        // Array to store process IDs
        int[] process = new int[n];

        // Input process IDs
        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
        }

        // Input failed process ID
        System.out.print("Enter failed process ID: ");
        int failedId = sc.nextInt();

        // To store index of failed process
        int failedIndex = -1;

        // Find index of failed process
        for (int i = 0; i < n; i++) {
            if (process[i] == failedId) {
                failedIndex = i;
                break;
            }
        }

        // Display failed process
        System.out.println("\nProcess " + failedId + " failed");

        // Leader initialization
        int leader = -1;

        // Start ring election from next process
        for (int i = 0; i < n; i++) {

            // Circular traversal using modulo
            int idx = (failedIndex + 1 + i) % n;

            // Show process participating in election
            System.out.println("Process " + process[idx] + " in election");

            // Find highest ID process
            if (process[idx] > leader) {
                leader = process[idx];
            }
        }

        // Final coordinator
        System.out.println("\nNew Coordinator = " + leader);

        // Close scanner
        sc.close();
    }
}

/*Ring Algorithm is a leader election algorithm where processes are arranged in a logical circle (ring).

🧠 How it works:
Any process can start the election.
An election message is passed from one process to the next in a circular order.
Each process adds/checks its ID.
After one full round, the highest ID process is selected as leader.*/
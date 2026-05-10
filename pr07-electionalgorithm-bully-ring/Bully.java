import java.util.Scanner;

public class Bully {

    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        // Array to store process IDs
        int[] process = new int[n];

        // Taking process IDs as input
        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
        }

        // Index of process that detects failure
        System.out.print("Enter failure detector index: ");
        int initiator = sc.nextInt();

        // Get actual process ID of initiator
        int initiatorId = process[initiator];

        // Election starts
        System.out.println("\nProcess " + initiatorId + " starts election");

        // Initially assume initiator is coordinator
        int coordinator = initiatorId;

        // Send election messages to higher ID processes
        for (int i = 0; i < n; i++) {

            // Check only higher ID processes
            if (process[i] > initiatorId) {

                // Election message sent
                System.out.println("Election message sent to " + process[i]);

                // Response from higher process
                System.out.println(process[i] + " replies OK");

                // Update coordinator candidate
                coordinator = process[i];
            }
        }

        // Final highest process becomes coordinator
        System.out.println("\nProcess " + coordinator + " is NEW COORDINATOR");

        // Close scanner
        sc.close();
    }
}


/*👉 Bully Algorithm is a leader election algorithm in distributed systems where the process with the highest ID becomes the coordinator.

🧠 How it works:
When a process detects that the leader has failed, it starts an election.
It sends messages to all higher ID processes.
If higher processes are alive, they respond and continue the election.
Finally, the highest ID process becomes the leader.*/
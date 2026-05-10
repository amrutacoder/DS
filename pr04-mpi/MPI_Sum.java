package pr04;

import mpi.*;

public class MPI_Sum {
    public static void main(String[] args) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] array = {1,2,3,4,5,6,7,8};
        int N = array.length;

        int chunk = N / size;
        int start = rank * chunk;
        int end = start + chunk;

        int localSum = 0;

        for (int i = start; i < end; i++)
            localSum += array[i];

        System.out.println("P" + rank + " partial sum: " + localSum);

        if (rank == 0) {
            int total = localSum;

            for (int i = 1; i < size; i++) {
                int[] buf = new int[1];
                MPI.COMM_WORLD.Recv(buf, 0, 1, MPI.INT, i, 0);
                total += buf[0];
            }

            System.out.println("Final Sum = " + total);

        } else {
            MPI.COMM_WORLD.Send(new int[]{localSum}, 0, 1, MPI.INT, 0, 0);
        }

        MPI.Finalize();
    }
}
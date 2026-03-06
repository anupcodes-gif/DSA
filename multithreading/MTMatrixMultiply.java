package multithreading;

import java.util.Arrays;

public class MTMatrixMultiply {
    static class Worker implements Runnable {
        int[][] A, B, C;
        int row;

        Worker(int[][] A, int[][] B, int[][] C, int row) {
            this.A = A; this.B = B; this.C = C; this.row = row;
        }

        public void run() {
            int n = A[0].length;
            int p = B[0].length;
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    C[row][j] += A[row][k] * B[k][j];
                }
            }
        }
    }

    public int[][] multiply(int[][] A, int[][] B) throws InterruptedException {
        int m = A.length;
        int p = B[0].length;
        int[][] C = new int[m][p];
        Thread[] threads = new Thread[m];

        for (int i = 0; i < m; i++) {
            threads[i] = new Thread(new Worker(A, B, C, i));
            threads[i].start();
        }

        for (Thread t : threads) t.join();
        return C;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};

        MTMatrixMultiply mm = new MTMatrixMultiply();
        int[][] C = mm.multiply(A, B);

        System.out.println("Matrix A: " + Arrays.deepToString(A));
        System.out.println("Matrix B: " + Arrays.deepToString(B));
        System.out.println("Result C: " + Arrays.deepToString(C));
    }
}

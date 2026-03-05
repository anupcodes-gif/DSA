package backtracking;

import java.util.Scanner;

public class NQueen {
    private int[][] board;
    private int N;

    public NQueen(int N) {
        this.N = N;
        this.board = new int[N][N];
    }

    public void solve() {
        if (solveNQueen(0)) {
            System.out.println("Solutions found successfully.");
        } else {
            System.out.println("No solution exists for N = " + N);
        }
    }

    private boolean solveNQueen(int row) {
        if (row == N) {
            printBoard();
            System.out.println("-----------------");
            return true;
        }

        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;

                res = solveNQueen(row + 1) || res;

                board[row][col] = 0;
            }
        }
        return res;
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Queens (N): ");
        int n = scanner.nextInt();
        NQueen solver = new NQueen(n);
        solver.solve();
        scanner.close();
    }
}

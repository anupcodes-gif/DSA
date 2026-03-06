package dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int n = values.length;

        System.out.println("Max Value: " + knapsack(W, weights, values, n));
    }

    public static int knapsack(int W, int[] weights, int[] values, int n) {
        int[][] DP = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    DP[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    DP[i][w] = Math.max(values[i - 1] + DP[i - 1][w - weights[i - 1]], DP[i - 1][w]);
                } else {
                    DP[i][w] = DP[i - 1][w];
                }
            }
        }

        return DP[n][W];
    }
}

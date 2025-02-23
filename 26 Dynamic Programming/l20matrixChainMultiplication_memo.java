import java.util.*;

public class l20matrixChainMultiplication_memo {
    public static int mcmMem(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0; // Single matrix case, no multiplication needed
        }

        if (dp[i][j] != -1) {
            return dp[i][j]; // Return precomputed result
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans; // Store result in dp array
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;

        int dp[][] = new int[n][n]; // Memoization table
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1); // Initialize dp array with -1 (uncomputed state)
        }

        System.out.println(mcmMem(arr, 1, n - 1, dp)); // Compute minimum cost using memoization
    }
}

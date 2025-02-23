public class l21minimumPartitioning {
    public static int minPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        
        // Calculate total sum of elements
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum / 2; // Target half of total sum

        int dp[][] = new int[n + 1][W + 1];

        // Bottom-up DP approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (arr[i - 1] <= j) { // If element can be included
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else { // If element cannot be included
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][W]; // Closest possible sum to half
        int sum2 = sum - sum1; // Remaining sum
        return Math.abs(sum1 - sum2); // Min partition difference
    }

    public static void main(String args[]) {
        int nums[] = {1, 6, 11, 5};
        System.out.println(minPartition(nums)); // Output: 1
    }
}

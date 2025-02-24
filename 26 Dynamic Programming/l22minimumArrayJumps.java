import java.util.*;

public class l22minimumArrayJumps {
    public static int minJumps(int nums[]){
        int n = nums.length;

        int dp[] = new int[n]; // DP array for jumps - SIZE : "n"

        Arrays.fill(dp, -1); // Initialize with -1
        dp[n-1] = 0; // Last index requires 0 jumps

        // Fill DP array
        for (int i = n-2; i >= 0; i--){
            int steps = nums[i]; // Max jump length
            int ans = Integer.MAX_VALUE; // Minimum jumps tracker

            // Check reachable indices
            for (int j = i+1; j <= i + steps && j < n; j++){
                if (dp[j] != -1){ // If reachable, update ans
                    ans = Math.min(ans, dp[j] + 1);
                }
            }

            if (ans != Integer.MAX_VALUE){ // Valid path check
                dp[i] = ans; // Update dp[i]
            }
        }

        return dp[0]; // Return min jumps
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(minJumps(nums));
    }
}

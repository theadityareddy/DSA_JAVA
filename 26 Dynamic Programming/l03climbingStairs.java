import java.util.*;

public class l03climbingStairs {

    public static int ans_Recursion(int n) {
        // base case
        if (n == 0)
            return 1; // ground to ground
        if (n < 0)
            return 0; // no way to go below ground - when n=0 and n-2=-1

        return ans_Recursion(n - 1) + ans_Recursion(n - 2);
    }

    public static int ans_Recur_memomisation(int n, int dp[]) {
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }

        if (dp[n] != -1) { // already calculated
            return dp[n];
        }

        dp[n] = dp[n - 1] + dp[n - 2];
        return dp[n];
    }

    public static int climbing_stair_Tabulation(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;

        // using normal recursion
        // System.out.println(ans_Recursion(n));

        // using memomisation
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        // System.out.println(ans_Recursion(n));

        // using tabulation
        System.out.println(climbing_stair_Tabulation(n));

    }
}
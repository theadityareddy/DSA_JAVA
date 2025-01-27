public class l15wildcardMatching {

    public static boolean isMatch(String s, String p) {
        int n = s.length(); // Length of the input string
        int m = p.length(); // Length of the pattern string
    
        // Dynamic programming table to store results of subproblems
        boolean dp[][] = new boolean[n + 1][m + 1];
    
        // Initialize the base case: Empty string matches empty pattern
        dp[0][0] = true;

        // If the pattern is empty, no string can match except an empty string
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
    
        // If the string is empty, only patterns consisting entirely of '*' can match
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
    
        // Fill the DP table in a bottom-up manner
        for (int i = 1; i < n + 1; i++) { // Loop through each character in the string
            for (int j = 1; j < m + 1; j++) { // Loop through each character in the pattern

                // Case 1: Characters match or pattern has a '?' (matches any single character)
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Case 2: Pattern has a '*' (matches zero or more characters)
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    // dp[i - 1][j]: '*' matches one or more characters
                    // dp[i][j - 1]: '*' matches zero characters
                }
                // Case 3: Characters do not match
                else {
                    dp[i][j] = false;
                }
            }
        }
    
        // Return whether the entire string matches the entire pattern
        return dp[n][m];
    }
    
    public static void main(String args[]) {
        String s = "baaabab";
        String p = "**ba*****ab";

        System.out.println(isMatch(s, p));
    }
}

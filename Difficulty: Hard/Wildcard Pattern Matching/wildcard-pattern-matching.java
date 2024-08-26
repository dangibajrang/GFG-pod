//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    public int wildCard(String pattern, String str) {
        int n = str.length();
        int m = pattern.length();

        // Create a DP table with (n+1) x (m+1) size
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: Empty pattern and empty string match
        dp[0][0] = true;

        // Fill the table for the pattern containing '*'
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char p = pattern.charAt(j - 1);
                char s = str.charAt(i - 1);

                if (p == '*') {
                    // '*' can match any sequence: either we ignore '*' or we match current character
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p == '?' || p == s) {
                    // '?' matches any single character or the characters match exactly
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        // Return 1 if they match, otherwise 0
        return dp[n][m] ? 1 : 0;
    }
}

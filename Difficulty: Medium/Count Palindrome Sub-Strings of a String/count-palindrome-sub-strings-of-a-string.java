//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            String S = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.CountPS(S, N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int CountPS(String s, int n) {
        // code here
        if (n < 2) {
            return 0; // No palindromic substring of length >= 2 can exist in strings of length < 2
        }
        
        
        // Create a 2D boolean array to store the palindrome status of substrings
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        
        
        
         // Check for palindromic substrings of length 2 separately
        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // Every single character is a palindrome
        }
        
        
        
        
        // Every single character is a palindrome, but we are not counting them as length < 2
        for (int i = 0; i < n - 1; i++) {
            // Check for palindromic substrings of length 2
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        
        // Check for palindromic substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        

        return count;

    }
}
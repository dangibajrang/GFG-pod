//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// class Solution {
//     public int editDistance(String str1, String str2) {
//         return editDistanceRecursive(str1, str2, str1.length(), str2.length());
//     }

//     // Recursive function to find the edit distance
//     private int editDistanceRecursive(String str1, String str2, int m, int n) {
//         // If the first string is empty, the only option is to insert all characters of the second string
//         if (m == 0) return n;
        
//         // If the second string is empty, the only option is to remove all characters of the first string
//         if (n == 0) return m;
        
//         // If the last characters are the same, no operation is needed for the last character
//         if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
//             return editDistanceRecursive(str1, str2, m - 1, n - 1);
//         }
        
//         // If the last characters are different, consider all possibilities:
//         // 1. Insert the last character of str2 into str1
//         // 2. Remove the last character of str1
//         // 3. Replace the last character of str1 with the last character of str2
//         int insert = editDistanceRecursive(str1, str2, m, n - 1);
//         int remove = editDistanceRecursive(str1, str2, m - 1, n);
//         int replace = editDistanceRecursive(str1, str2, m - 1, n - 1);
        
//         // Return the minimum of the three operations plus 1 (for the current operation)
//         return 1 + Math.min(insert, Math.min(remove, replace));
//     }
// }




class Solution {
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create a DP table with dimensions (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    // If the first string is empty, we need to insert all characters of the second string
                    dp[i][j] = j;
                } else if (j == 0) {
                    // If the second string is empty, we need to remove all characters of the first string
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If the last characters are the same, no operation is needed for the last character
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the last characters are different, consider all possibilities
                    int insert = dp[i][j - 1];
                    int remove = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    
                    dp[i][j] = 1 + Math.min(insert, Math.min(remove, replace));
                }
            }
        }
        
        // Return the result from dp[m][n]
        return dp[m][n];
    }
}


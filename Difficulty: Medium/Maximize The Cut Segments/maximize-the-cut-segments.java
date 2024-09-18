//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int maximizeCuts(int n, int x, int y, int z) {
        // DP array to store the maximum cuts possible for each length
        int[] dp = new int[n + 1];
        
        // Initialize dp[0] as 0 because no cuts are needed for length 0
        dp[0] = 0;

        // Initialize all dp values to -1 indicating they're not yet computed
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
        }

        // Iterate through all lengths from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check for x
            if (i >= x && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            // Check for y
            if (i >= y && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            // Check for z
            if (i >= z && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        // If dp[n] is -1, no valid cuts were found, so return 0
        return dp[n] == -1 ? 0 : dp[n];
    }
}

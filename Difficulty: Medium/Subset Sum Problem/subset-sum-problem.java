//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Base Case: Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Base Case: No subset can form a positive sum if no elements are present
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // Exclude the current element
                dp[i][j] = dp[i - 1][j];

                // Include the current element if it is not greater than the sum
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}

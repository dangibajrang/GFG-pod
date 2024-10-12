//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            int res = obj.pairWithMaxSum(a);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
           // Edge case: If the size of the array is less than 2, return -1
        if (arr.length < 2) {
            return -1;
        }
        
        int maxSum = -1; // Initialize max sum
        
        // Traverse through adjacent pairs and compute their sums
        for (int i = 0; i < arr.length - 1; i++) {
            // Calculate the sum of adjacent elements
            int currentSum = arr[i] + arr[i + 1];
            // Update the max sum if current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum; // Return the maximum sum found
    }
}

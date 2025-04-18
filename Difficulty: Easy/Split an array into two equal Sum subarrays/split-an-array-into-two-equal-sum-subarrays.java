//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

//prefix sum
class Solution {
    public boolean canSplit(int arr[]) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, it's not possible to split it into two equal parts
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 2;
        int prefixSum = 0;
        
        // Iterate through the array and calculate prefix sum
        for (int num : arr) {
            prefixSum += num;
            
            // If at any point the prefix sum equals the target sum, return true
            if (prefixSum == targetSum) {
                return true;
            }
        }
        
        // If no split point is found, return false
        return false;
    }
}

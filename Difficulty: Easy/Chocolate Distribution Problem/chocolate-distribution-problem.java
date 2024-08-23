//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // Sort the array to facilitate finding minimum difference
        Collections.sort(a);
        
        // Initialize the minimum difference to a large number
        long minDiff = Long.MAX_VALUE;
        
        // Iterate over the array to find the minimum difference
        for (int i = 0; i <= n - m; i++) {
            // Find the difference between the maximum and minimum in the current subarray of size M
            long diff = a.get(i + m - 1) - a.get(i);
            // Update the minimum difference
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        
        // Return the minimum difference found
        return minDiff;
    }
}

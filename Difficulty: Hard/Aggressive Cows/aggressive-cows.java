//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        int low = 1; // Minimum possible distance
        int high = stalls[n-1] - stalls[0]; // Maximum possible distance
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlaceCows(stalls, n, k, mid)) {
                result = mid; // If it's possible, this might be the answer
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }
        
        return result;
    }
    
    private static boolean canPlaceCows(int[] stalls, int n, int k, int distance) {
        int count = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0];
        
        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];
                
                if (count == k) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

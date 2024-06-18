//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int ans = 0;
        for (int x = 1; x <= 2 * r; x++) {
            for (int y = 1; y <= 2 * r; y++) {
                if (x * x + y * y <= 4 * r * r) {
                    ans++;
                }
            }
        }
        return ans;
    }
};

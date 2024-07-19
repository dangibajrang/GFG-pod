//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String strs[]) {
        // code here
     if (strs == null || strs.length == 0) return "-1";
        
        // Set the initial prefix to the first string
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix length by one
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, return -1 indicating no common prefix
                if (prefix.isEmpty()) return "-1";
            }
        }
        return prefix;
    }
}
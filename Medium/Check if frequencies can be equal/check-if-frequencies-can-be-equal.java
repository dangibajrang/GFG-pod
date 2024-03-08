//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    // Function to check if the frequencies of characters in the string satisfy specific conditions
    boolean sameFreq(String s) {
        // HashMap to store the frequency of each character in the string
        HashMap<Character, Integer> mm = new HashMap<>();
        
        // Count the frequency of each character in the string and store in the HashMap
        for (int i = 0; i < s.length(); i++) {
            mm.put(s.charAt(i), mm.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        // Variables to store minimum and maximum frequencies, and counts for minimum and maximum frequencies
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, mxCount = 0, mnCount = 0;

        // Iterate through the entries in the HashMap to find minimum and maximum frequencies
        for (Map.Entry<Character, Integer> x : mm.entrySet()) {
            mn = Math.min(mn, x.getValue());
            mx = Math.max(mx, x.getValue());
        }

        // Count the number of characters with maximum and minimum frequencies
        for (Map.Entry<Character, Integer> x : mm.entrySet()) {
            if (x.getValue() == mx)
                mxCount++;
            else if (x.getValue() == mn)
                mnCount++;
        }

        // Check specific conditions to determine if the frequencies satisfy the requirements
        if (mn == mx - 1 && mxCount == 1 || (mn == mx))
            return true;
        if (mnCount == 1 && mn == 1 && mxCount + mnCount == mm.size())
            return true;

        // Return false if none of the conditions are met
        return false;
    }
}

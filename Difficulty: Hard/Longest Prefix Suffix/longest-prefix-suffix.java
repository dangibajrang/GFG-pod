//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // Get the length of the input string
        int n = str.length();
        
        // Create an array to store the LPS values. This will hold the length of the longest proper prefix which is also a suffix for substrings
        int[] lpsArray = new int[n];
        
        // Initialize the first value of the LPS array to 0. The first character doesn't have any proper prefix or suffix
        lpsArray[0] = 0;
        
        // Variable to keep track of the length of the previous longest prefix suffix
        int length = 0;
        
        // Start iterating from the second character (index 1)
        int i = 1;
        
        // Loop through the string to fill the LPS array
        while (i < n) {
            // If the current character matches the character at the position `length`
            if (str.charAt(i) == str.charAt(length)) {
                // Increment the length of the current LPS
                length++;
                
                // Set the LPS value for index `i` as `length`
                lpsArray[i] = length;
                
                // Move to the next character
                i++;
            } else {
                // If there is a mismatch
                if (length != 0) {
                    // Set the length to the previous LPS value for the next comparison
                    length = lpsArray[length - 1];
                } else {
                    // If length is 0, set the LPS value for index `i` as 0 and move to the next character
                    lpsArray[i] = 0;
                    i++;
                }
            }
        }
        
        // The last value in the LPS array gives the longest proper prefix which is also a suffix
        return lpsArray[n - 1];
    }
}

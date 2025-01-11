//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        
           // Initialize a HashMap to store the last index of each character.
        HashMap<Character, Integer> lastSeen = new HashMap<>();

        // Initialize variables for the starting point of the current window and the maximum length.
        int start = 0, maxLength = 0;

        // Traverse the string.
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end); // Get the current character.

            // If the character is already in the map and its index is within the current window,
            // update the start of the window to exclude the repeated character.
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= start) {
                start = lastSeen.get(currentChar) + 1;
            }

            // Update the character's last seen index to the current position.
            lastSeen.put(currentChar, end);

            // Calculate the length of the current substring and update the maximum length if needed.
            maxLength = Math.max(maxLength, end - start + 1);
        }

        // Return the maximum length of a substring with all distinct characters.
        return maxLength;
    }
}
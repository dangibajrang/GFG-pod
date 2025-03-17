//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int longestStringChain(String words[]) {
        Arrays.sort(words, Comparator.comparingInt(String::length)); // Step 1: Sort words by length
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLength = 1;

        for (String word : words) {
            int maxChain = 1; // Minimum chain length for this word

            // Step 2: Generate predecessors by removing one character at a time
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                
                if (dp.containsKey(predecessor)) {
                    maxChain = Math.max(maxChain, dp.get(predecessor) + 1);
                }
            }

            dp.put(word, maxChain); // Store the longest chain for this word
            maxLength = Math.max(maxLength, maxChain); // Update max chain length
        }
        
        return maxLength;
    }
}

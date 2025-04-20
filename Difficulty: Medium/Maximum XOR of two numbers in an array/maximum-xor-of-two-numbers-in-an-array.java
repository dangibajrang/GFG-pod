//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int maxXor(int[] arr) {
        
        // Initialize maxResult to store the maximum XOR found.
        int maxResult = 0;
        
        // Initialize mask to progressively consider the higher bits.
        int mask = 0;
        
        // Loop from the highest bit (31st) down to the lowest (0th).
        for (int i = 31; i >= 0; i--) {
            
            // Set the current bit in mask to include this bit in prefix.
            mask = mask | (1 << i);
            
            // Create a set to store unique prefixes of all numbers using current mask.
            HashSet<Integer> prefixes = new HashSet<>();
            for (int num : arr) {
                // Mask the number to get prefix till ith bit.
                prefixes.add(num & mask);
            }
            
            // Propose a new candidate for maxResult by setting the current bit to 1.
            int candidate = maxResult | (1 << i);
            
            // Now check if there are two prefixes that can produce the candidate XOR.
            for (int prefix : prefixes) {
                // If (candidate ^ prefix) is in the set, this bit can be set to 1.
                if (prefixes.contains(candidate ^ prefix)) {
                    maxResult = candidate; // Confirm this bit can be 1.
                    break;
                }
            }
        }
        
        // Return the final maximum XOR value.
        return maxResult;
    }
}

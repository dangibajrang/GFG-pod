//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        // Initialize a hashmap to store the first occurrence of prefix sum
        Map<Integer, Integer> prefixMap = new HashMap<>();
        
        // Initialize variables
        int maxLength = 0;  // To store the maximum length of subarray
        int prefixSum = 0;  // To calculate prefix sum
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Convert 0 to -1 to find equal number of 0s and 1s
            prefixSum += (arr[i] == 0) ? -1 : 1;

            // If prefixSum is 0, it means the subarray from index 0 to i has equal number of 0s and 1s
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // If prefixSum is found in the map, we have a subarray with equal number of 0s and 1s
            if (prefixMap.containsKey(prefixSum)) {
                // Calculate the length of the subarray
                maxLength = Math.max(maxLength, i - prefixMap.get(prefixSum));
            } else {
                // Store the first occurrence of the prefixSum
                prefixMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}

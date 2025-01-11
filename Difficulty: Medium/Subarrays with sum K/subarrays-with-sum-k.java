//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        
         // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        
        // Variable to keep track of the cumulative sum
        int currentSum = 0;
        // Count of subarrays with the sum exactly equal to k
        int count = 0;

        // Initialize the map with the prefix sum 0 having a frequency of 1
        // This handles cases where a prefix itself is a valid subarray with sum k
        prefixSumCount.put(0, 1);

        // Iterate over the array
        for (int num : arr) {
            // Update the cumulative sum
            currentSum += num;

            // Check if (currentSum - k) exists in the map
            // If it does, it means there exists a subarray ending at the current index with sum k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the frequency of the current prefix sum in the map
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        // Return the total count of subarrays with sum k
        return count;
    }
}
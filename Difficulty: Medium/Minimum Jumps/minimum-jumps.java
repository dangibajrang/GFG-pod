//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // Edge cases
        if (arr.length == 1) return 0; // No jump needed if we are already at the last element
        if (arr[0] == 0) return -1;    // Cannot move anywhere if the first element is 0

        // Initialize variables
        int maxReach = arr[0];  // The farthest we can reach initially
        int steps = arr[0];     // Steps we can take before needing a jump
        int jumps = 1;          // We need at least one jump (starting jump)

        // Traverse the array
        for (int i = 1; i < arr.length; i++) {
            // If we have reached the last element, return the number of jumps
            if (i == arr.length - 1) return jumps;

            // Update maxReach for the current index
            maxReach = Math.max(maxReach, i + arr[i]);

            // Decrease steps for the current index
            steps--;

            // If no steps are left
            if (steps == 0) {
                jumps++; // We must make a jump

                // Check if we can reach further
                if (i >= maxReach) return -1; // If we are stuck, return -1

                // Reset the steps to the amount of steps we can take from the current position
                steps = maxReach - i;
            }
        }

        return -1;  // In case the end is not reachable
    }
}

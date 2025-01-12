//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int aggressiveCows(int[] stalls, int cows) {
        // Step 1: Sort the stalls
        Arrays.sort(stalls);

        // Step 2: Initialize binary search boundaries
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        // Step 3: Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Step 4: Check if this distance is feasible
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid; // Update result
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }

        // Step 5: Return the largest minimum distance
        return result;
    }

    // Helper function to check if we can place cows with at least 'distance' apart
    private boolean canPlaceCows(int[] stalls, int cows, int distance) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0]; // Track the last placed cow's position

        for (int i = 1; i < stalls.length; i++) {
            // Place the next cow only if the current stall is at least 'distance' away
            if (stalls[i] - lastPosition >= distance) {
                count++; // Increment the cow count
                lastPosition = stalls[i]; // Update the last placed cow's position

                // If all cows are placed, return true
                if (count == cows) {
                    return true;
                }
            }
        }

        // If not all cows could be placed, return false
        return false;
    }
}

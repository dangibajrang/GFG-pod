//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
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

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {
        // If the array is empty, return 0 (though constraints ensure array length >= 1)
        if (arr.length == 0) return 0;

        // Initialize maxSum and currentSum with the first element of the array
        long maxSum = arr[0];
        long currentSum = arr[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update currentSum to be the maximum of the current element or currentSum + current element
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update maxSum to be the maximum of itself or currentSum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] arr1 = {1, 2, 3, -2, 5};
        System.out.println(sol.maxSubarraySum(arr1)); // Output: 9

        // Test case 2
        int[] arr2 = {-1, -2, -3, -4};
        System.out.println(sol.maxSubarraySum(arr2)); // Output: -1

        // Test case 3
        int[] arr3 = {5, 4, 7};
        System.out.println(sol.maxSubarraySum(arr3)); // Output: 16

        // Additional Test cases
        int[] arr4 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubarraySum(arr4)); // Output: 6

        int[] arr5 = {10, -1, 2, 3, 4, -5};
        System.out.println(sol.maxSubarraySum(arr5)); // Output: 18
    }
}


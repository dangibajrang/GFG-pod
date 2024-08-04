//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        if (n == 0) return 0;

        // Initialize maxSoFar, minSoFar, and result with the first element
        long maxSoFar = arr[0];
        long minSoFar = arr[0];
        long result = arr[0];

        // Traverse the array from the second element
        for (int i = 1; i < n; i++) {
            // If arr[i] is negative, swap maxSoFar and minSoFar
            if (arr[i] < 0) {
                long temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Update maxSoFar and minSoFar
            maxSoFar = Math.max(arr[i], maxSoFar * arr[i]);
            minSoFar = Math.min(arr[i], minSoFar * arr[i]);

            // Update result
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] arr1 = {6, -3, -10, 0, 2};
        int n1 = arr1.length;
        System.out.println(sol.maxProduct(arr1, n1)); // Output: 180

        // Test case 2
        int[] arr2 = {2, 3, 4, 5, -1, 0};
        int n2 = arr2.length;
        System.out.println(sol.maxProduct(arr2, n2)); // Output: 120

        // Test case 3
        int[] arr3 = {2, 3, 4};
        int n3 = arr3.length;
        System.out.println(sol.maxProduct(arr3, n3)); // Output: 24

        // Additional Test cases
        int[] arr4 = {-2, -3, 0, -2, -40};
        int n4 = arr4.length;
        System.out.println(sol.maxProduct(arr4, n4)); // Output: 240

        int[] arr5 = {-1, -3, -10, 0, 60};
        int n5 = arr5.length;
        System.out.println(sol.maxProduct(arr5, n5)); // Output: 60
    }
}

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // Function to find the missing number
    int missingNumber(int n, int arr[]) {
        // Calculate the sum of first n natural numbers
        long totalSum = (long) n * (n + 1) / 2;

        // Calculate the sum of elements in the given array
        long arraySum = 0;
        for (int i = 0; i < n - 1; i++) {
            arraySum += arr[i];
        }

        // The missing number is the difference between totalSum and arraySum
        return (int) (totalSum - arraySum);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] arr1 = {1, 2, 3, 5};
        int n1 = 5;
        System.out.println(sol.missingNumber(n1, arr1)); // Output: 4

        // Test case 2
        int[] arr2 = {1};
        int n2 = 2;
        System.out.println(sol.missingNumber(n2, arr2)); // Output: 2

        // Additional Test case
        int[] arr3 = {1, 2, 4, 5, 6};
        int n3 = 6;
        System.out.println(sol.missingNumber(n3, arr3)); // Output: 3
    }
}

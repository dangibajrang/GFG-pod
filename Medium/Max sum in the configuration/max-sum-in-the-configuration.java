//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        // Calculate the sum of array elements and the initial value of curSum
        long sum = 0, curSum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            curSum += (long)i * a[i];
        }

        // Initialize the result with the initial curSum
        long res = curSum;

        // Iterate through the array to find the maximum value of curSum after rotations
        for (int i = 1; i < n; i++) {
            // Calculate the next value of curSum after rotating the array
            curSum = curSum - (sum - a[i - 1]) + (long)a[i - 1] * (n - 1);
            // Update the result if the new curSum is greater
            res = Math.max(res, curSum);
        }

        return res;
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();

    //     // Test case
    //     int[] a = new int[100000];
    //     for (int i = 0; i < 100000; i++) a[i] = i + 1;
    //     int n = 100000;
    //     System.out.println(sol.max_sum(a, n)); // Expected output: 2717098381054

    //     // Additional test cases
    //     int[] b = {1, 2, 3, 4};
    //     System.out.println(sol.max_sum(b, 4)); // Expected output: 20
        
    //     int[] c = {-1, 2, -3, 4};
    //     System.out.println(sol.max_sum(c, 4)); // Expected output: 5
        
    //     int[] d = {-1, -2, -3, -4};
    //     System.out.println(sol.max_sum(d, 4)); // Expected output: -4
    // }
}

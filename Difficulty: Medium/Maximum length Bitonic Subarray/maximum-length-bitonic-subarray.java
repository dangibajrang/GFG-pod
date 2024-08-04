//{ Driver Code Starts
//Initial Template for Java





import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().bitonic(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    // Function to find length of longest bitonic subarray
    public int bitonic(int[] arr, int n) {
        // if arr is empty
        if (n == 0) return 0;

        // initializing maxLen
        int maxLen = 1;

        int start = 0;
        int nextStart = 0;

        int j = 0;
        while (j < n - 1) {
            // look for end of ascent
            while (j < n - 1 && arr[j] <= arr[j + 1]) j++;

            // look for end of descent
            while (j < n - 1 && arr[j] >= arr[j + 1]) {
                // adjusting nextStart;
                // this will be necessarily executed at least once,
                // when we detect the start of the descent
                if (j < n - 1 && arr[j] > arr[j + 1]) nextStart = j + 1;
                j++;
            }

            // updating maxLen, if required
            maxLen = Math.max(maxLen, j - (start - 1));

            start = nextStart;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] arr1 = {12, 4, 78, 90, 45, 23};
        int n1 = arr1.length;
        System.out.println(sol.bitonic(arr1, n1)); // Output: 5

        // Test case 2
        int[] arr2 = {10, 20, 30, 40};
        int n2 = arr2.length;
        System.out.println(sol.bitonic(arr2, n2)); // Output: 4
        
        // Additional Test cases
        int[] arr3 = {2, 28, 84, 14, 89, 16, 27, 17, 41, 8, 42, 38, 52, 35, 66, 30, 11, 18, 53, 9, 73, 59, 59, 17, 93, 82, 20};
        int n3 = arr3.length;
        System.out.println(sol.bitonic(arr3, n3)); // Output: 5

        int[] arr4 = {6, 7, 8, 9, 10, 8, 7, 6, 5};
        int n4 = arr4.length;
        System.out.println(sol.bitonic(arr4, n4)); // Output: 9
        
        int[] arr5 = {12, 11, 40, 5, 3, 1};
        int n5 = arr5.length;
        System.out.println(sol.bitonic(arr5, n5)); // Output: 4
    }
}

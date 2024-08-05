//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            new Solution().leftRotate(nums, d);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to left rotate arr[] of size n by d elements
    void leftRotate(int arr[], int d) {
        int n = arr.length;
        if (d == 0 || d == n) {
            return;
        }
        
        // In case d is greater than n, use d % n
        d = d % n;
        
        // Step 1: Reverse the first d elements
        reverseArray(arr, 0, d - 1);
        
        // Step 2: Reverse the remaining elements
        reverseArray(arr, d, n - 1);
        
        // Step 3: Reverse the whole array
        reverseArray(arr, 0, n - 1);
    }
    
    // Utility function to reverse a part of the array
    void reverseArray(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}



// For an input array [-1, -2, -3, 4, 5, 6, 7] and d = 2:

// Reverse the first 2 elements: [-2, -1, -3, 4, 5, 6, 7]
// Reverse the remaining elements: [-2, -1, 7, 6, 5, 4, -3]
// Reverse the entire array: [-3, 4, 5, 6, 7, -1, -2]
// Thus, the array is successfully rotated by 2 elements to the left.
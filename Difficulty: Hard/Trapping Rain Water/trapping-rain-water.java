//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int[] arr) {
        int n = arr.length;

        // Initialize two pointers and variables to store max heights
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;

        // Variable to store total water trapped
        int totalWater = 0;

        // Traverse the array using two pointers
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                // If the current left height is less, process the left side
                if (arr[left] >= leftMax) {
                    leftMax = arr[left]; // Update leftMax
                } else {
                    totalWater += leftMax - arr[left]; // Water trapped at current left
                }
                left++; // Move left pointer
            } else {
                // If the current right height is less, process the right side
                if (arr[right] >= rightMax) {
                    rightMax = arr[right]; // Update rightMax
                } else {
                    totalWater += rightMax - arr[right]; // Water trapped at current right
                }
                right--; // Move right pointer
            }
        }

        // Return the total water trapped
        return totalWater;
    }
}

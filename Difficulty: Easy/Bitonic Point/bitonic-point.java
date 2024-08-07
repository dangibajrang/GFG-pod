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

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] arr, int n) {
        // code here
       int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the maximum element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && 
                (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            } 
            // If the middle element is greater than the next element, the peak must be to the left (including mid)
            else if (mid < n - 1 && arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            } 
            // If the middle element is less than the next element, the peak must be to the right
            else {
                low = mid + 1;
            }
        }
        
        // This line should not be reached if the input array is bitonic
        return -1;
    }
}
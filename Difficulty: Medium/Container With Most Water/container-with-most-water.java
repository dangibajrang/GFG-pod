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


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        int left = 0; // Starting pointer
        int right = arr.length - 1; // Ending pointer
        int maxArea = 0; // To store the maximum water area

        while (left < right) {
            // Calculate the current area
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;

            // Update the maximum area if the current area is greater
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the smaller height
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the maximum water area found
    }
}

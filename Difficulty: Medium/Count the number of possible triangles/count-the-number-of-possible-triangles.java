//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        
        // Sort the array to simplify the process of checking the triangle condition.
        Arrays.sort(arr);

        int n = arr.length; // Length of the array
        int count = 0;      // To store the number of triangles

        // Iterate over the array, treating arr[k] as the largest side of the triangle
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;       // Start pointer (smallest side)
            int j = k - 1;   // End pointer (middle side)

            // Use two pointers to find pairs that satisfy the triangle condition
            while (i < j) {
                // If arr[i] + arr[j] > arr[k], it means all pairs between i and j
                // can form valid triangles with arr[k].
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i); // Add all valid pairs
                    j--;             // Decrease j to check for smaller middle side
                } else {
                    i++;             // Increase i to check for larger smallest side
                }
            }
        }

        return count; // Return the total count of possible triangles
    }
}
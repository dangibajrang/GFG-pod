//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public int countTriplets(int[] arr, int target) {
        // Initialize the result variable to store the count of triplets
        int ans = 0;

        // Get the size of the array
        int size = arr.length;

        // Iterate through each element of the array as the first element of the triplet
        for (int i = 0; i < size; i++) {
            // Set up two pointers: one starting from the next element and the other from the end
            int j = i + 1, k = size - 1;

            // Use the two-pointer technique to find valid triplets
            while (j < k) {
                // Calculate the sum of the current triplet
                int sum = arr[i] + arr[j] + arr[k];

                // If the sum is less than the target, move the left pointer forward
                if (sum < target) {
                    j++;
                }
                // If the sum is greater than the target, move the right pointer backward
                else if (sum > target) {
                    k--;
                }
                // If the sum equals the target, count all valid triplets
                else {
                    // Store the values at the current positions of the left and right pointers
                    int e1 = arr[j], e2 = arr[k];

                    // Initialize counters for duplicates of the left and right values
                    int c1 = 0, c2 = 0;

                    // Count occurrences of the left pointer value
                    while (j <= k && arr[j] == e1) {
                        c1++;  // Increment the count for the left value
                        j++;   // Move the left pointer forward
                    }

                    // Count occurrences of the right pointer value
                    while (j <= k && arr[k] == e2) {
                        c2++;  // Increment the count for the right value
                        k--;   // Move the right pointer backward
                    }

                    // If the left and right values are the same, calculate combinations for duplicates
                    if (e1 == e2) {
                        ans += (c1 * (c1 - 1)) / 2;  // Add combinations of pairs from duplicates
                    } 
                    // Otherwise, multiply the counts of left and right duplicates
                    else {
                        ans += c1 * c2;
                    }
                }
            }
        }
        // Return the total count of triplets
        return ans;
    }
}

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        
         // Handle edge case where there are fewer than 2 elements
        if (arr.length < 2) {
            return new ArrayList<>();
        }

        // Sort the array
        Arrays.sort(arr);

        // Initialize pointers and variables
        int left = 0, right = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int maxAbsDifference = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        // Two-pointer technique
        while (left < right) {
            int sum = arr[left] + arr[right];

            // Update result if this pair is closer to the target
            if (Math.abs(target - sum) < Math.abs(target - closestSum) || 
               (Math.abs(target - sum) == Math.abs(target - closestSum) && (arr[right] - arr[left] > maxAbsDifference))) {
                closestSum = sum;
                maxAbsDifference = arr[right] - arr[left];
                result = Arrays.asList(arr[left], arr[right]);
            }

            // Move pointers based on the current sum
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
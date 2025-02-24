//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java


// If the array is sorted: ✅ Use the Two-Pointer Approach (Best performance)
// If the array is unsorted: ✅ Use HashMap
// For small inputs (N < 1000): ✅ Brute Force is fine

// class Solution {
//     int countPairs(int arr[], int target) {
//         int left = 0, right = arr.length - 1;
//         int count = 0;

//         while (left < right) {
//             int sum = arr[left] + arr[right];

//             if (sum == target) {
//                 int lCount = 1, rCount = 1;
                
//                 // Count occurrences of arr[left]
//                 while (left + 1 < right && arr[left] == arr[left + 1]) {
//                     lCount++;
//                     left++;
//                 }
                
//                 // Count occurrences of arr[right]
//                 while (right - 1 > left && arr[right] == arr[right - 1]) {
//                     rCount++;
//                     right--;
//                 }

//                 // If both numbers are the same, count all pairs within the same number
//                 if (arr[left] == arr[right]) {
//                     count += (lCount * (lCount - 1)) / 2;
//                 } else {
//                     count += lCount * rCount;
//                 }

//                 left++;
//                 right--;
//             } 
//             else if (sum < target) {
//                 left++;
//             } 
//             else {
//                 right--;
//             }
//         }
//         return count;
//     }
// }


class Solution {
    int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;

            // If complement is already in the map, add its count
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }

            // Store the occurrence of num
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}




//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends
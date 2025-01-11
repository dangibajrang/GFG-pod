//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        // HashMap to store frequency of prefix XOR values
        HashMap<Integer, Integer> prefixXorCount = new HashMap<>();

        // Initialize variables
        int prefixXor = 0;  // Current cumulative XOR
        long count = 0;     // Total count of subarrays with XOR equal to k

        // Iterate through the array
        for (int num : arr) {
            // Update the prefix XOR
            prefixXor ^= num;

            // If the prefix XOR itself is equal to k, increment count
            if (prefixXor == k) {
                count++;
            }

            // Check if (prefixXor ^ k) exists in the map
            int requiredXor = prefixXor ^ k;
            if (prefixXorCount.containsKey(requiredXor)) {
                count += prefixXorCount.get(requiredXor);
            }

            // Update the frequency of the current prefix XOR in the map
            prefixXorCount.put(prefixXor, prefixXorCount.getOrDefault(prefixXor, 0) + 1);
        }

        // Return the total count
        return count;
    }
}
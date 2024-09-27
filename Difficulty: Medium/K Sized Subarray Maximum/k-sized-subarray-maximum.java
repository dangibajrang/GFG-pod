//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
    // Initialize an ArrayList to store the maximum of each subarray
    ArrayList<Integer> ans = new ArrayList<>();
    
    // Initialize a deque (double-ended queue) to store indices of useful elements
    Deque<Integer> dq = new ArrayDeque<>();
    
    // Traverse through each element of the array
    for(int i = 0; i < arr.length; i++) {
        
        // Remove elements from the front of the deque that are out of the current window (i-k)
        if(dq.size() != 0 && dq.getFirst() == i - k) dq.removeFirst();
        
        // Remove elements from the back of the deque if they are smaller than the current element
        // because they are not useful anymore as current element is larger
        while(dq.size() != 0 && arr[dq.getLast()] <= arr[i]) dq.removeLast();
        
        // Add the current element index at the back of the deque
        dq.add(i);
        
        // Once we have traversed at least 'k' elements (i >= k - 1), add the maximum element of 
        // the current window to the result list. The maximum element is at the front of the deque
        if(i >= k - 1) ans.add(arr[dq.getFirst()]);
    }
    
    // Return the list of maximums for all subarrays of size 'k'
    return ans;
}

}
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        
         // Result list to store the count of distinct elements in each window
        ArrayList<Integer> result = new ArrayList<>();

        // HashMap to store the frequency of elements in the current window
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Traverse the first window and populate the frequency map
        for (int i = 0; i < k; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        // Add the count of distinct elements of the first window to the result
        result.add(frequencyMap.size());

        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            // Remove the element going out of the window
            int elementToRemove = arr[i - k];
            if (frequencyMap.get(elementToRemove) == 1) {
                frequencyMap.remove(elementToRemove);
            } else {
                frequencyMap.put(elementToRemove, frequencyMap.get(elementToRemove) - 1);
            }

            // Add the new element coming into the window
            int elementToAdd = arr[i];
            frequencyMap.put(elementToAdd, frequencyMap.getOrDefault(elementToAdd, 0) + 1);

            // Add the count of distinct elements of the current window to the result
            result.add(frequencyMap.size());
        }

        // Return the result list
        return result;

    }
}

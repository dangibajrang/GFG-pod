//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java


class Solution {
    // Function to sort the array according to the frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // Frequency map to store the frequency of each element.
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Convert the array to a list for sorting with custom comparator.
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }

        // Sort the list with a custom comparator.
        Collections.sort(result, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            // Sort primarily by frequency (descending order)
            if (freqA != freqB) {
                return freqB - freqA;
            }
            // If frequencies are the same, sort by the value (ascending order)
            return a - b;
        });

        return result;
    }
}


//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends
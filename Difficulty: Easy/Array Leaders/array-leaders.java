//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {

            // input size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // inserting elements in the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            StringBuffer str = new StringBuffer();
            ArrayList<Integer> res = new ArrayList<Integer>();

            // calling leaders() function
            res = obj.leaders(n, arr);

            for (int i = 0; i < res.size(); i++) {
                ot.print(res.get(i) + " ");
            }

            ot.println();
        }
        ot.close();
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case: if array is empty
        if (n == 0) return result;
        
        // Start from the rightmost element
        int maxFromRight = arr[n - 1];
        result.add(maxFromRight);
        
        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                result.add(arr[i]);
                maxFromRight = arr[i];
            }
        }
        
        // Reverse the result list to maintain the original order of leaders
        ArrayList<Integer> leadersInOrder = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            leadersInOrder.add(result.get(i));
        }
        
        return leadersInOrder;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr1.length, arr1)); // Output: [17, 5, 2]

        // Test case 2
        int[] arr2 = {10, 4, 2, 4, 1};
        System.out.println(leaders(arr2.length, arr2)); // Output: [10, 4, 4, 1]

        // Test case 3
        int[] arr3 = {5, 10, 20, 40};
        System.out.println(leaders(arr3.length, arr3)); // Output: [40]

        // Test case 4
        int[] arr4 = {30, 10, 10, 5};
        System.out.println(leaders(arr4.length, arr4)); // Output: [30, 10, 10, 5]
    }
}


//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        
        // Step 1: Find Next Smaller Element (NSE)
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = n; // No smaller element, set to n
        }

        // Step 2: Find Previous Smaller Element (PSE)
        int[] left = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            left[stack.pop()] = -1; // No smaller element, set to -1
        }

        // Step 3: Fill the result using window sizes
        int[] window = new int[n + 1]; // Store max min values for window sizes
        Arrays.fill(window, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int size = right[i] - left[i] - 1;
            window[size] = Math.max(window[size], arr[i]);
        }

        // Step 4: Fill the result array by propagating values
        for (int i = n - 1; i >= 1; i--) {
            window[i] = Math.max(window[i], window[i + 1]);
        }

        // Convert array to ArrayList
        for (int i = 1; i <= n; i++) {
            result.set(i - 1, window[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(sol.maxOfMins(arr)); // Output: [70, 30, 20, 10, 10, 10, 10]
    }
}

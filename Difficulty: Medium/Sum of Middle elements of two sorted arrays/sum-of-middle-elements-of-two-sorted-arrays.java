//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int i = 0, j = 0, count = 0;
        int m1 = -1, m2 = -1;
        
        // Traverse through the arrays until we find the middle elements
        for (count = 0; count <= n; count++) {
            if (i != n && (j == n || arr1[i] <= arr2[j])) {
                if (count == n-1) {
                    m1 = arr1[i];
                }
                if (count == n) {
                    m2 = arr1[i];
                }
                i++;
            } else {
                if (count == n-1) {
                    m1 = arr2[j];
                }
                if (count == n) {
                    m2 = arr2[j];
                }
                j++;
            }
        }
        
        // Sum of the middle elements
        return m1 + m2;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends
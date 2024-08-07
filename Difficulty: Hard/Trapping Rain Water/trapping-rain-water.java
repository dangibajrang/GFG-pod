//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends

class Solution {
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Initialize pointers and variables
        int left = 0, right = n - 1;
        long leftMax = 0, rightMax = 0;
        long waterTrapped = 0;

        // Traverse the array
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }

        // Return the total amount of water trapped
        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 0, 0, 2, 0, 4};
        int n1 = 6;
        System.out.println(trappingWater(arr1, n1)); // Output: 10

        int[] arr2 = {7, 4, 0, 9};
        int n2 = 4;
        System.out.println(trappingWater(arr2, n2)); // Output: 10

        int[] arr3 = {6, 9, 9};
        int n3 = 3;
        System.out.println(trappingWater(arr3, n3)); // Output: 0
    }
}



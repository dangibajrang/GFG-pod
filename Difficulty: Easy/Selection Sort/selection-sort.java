//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution {
    // Function to find the index of the minimum element in the array starting from index i
    int select(int arr[], int i) {
        // Assume the minimum element is at the current starting index
        int minIndex = i;
        // Iterate through the rest of the array to find the actual minimum element
        for (int j = i + 1; j < arr.length; j++) {
            // Update the minimum index if a smaller element is found
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        // Return the index of the minimum element found
        return minIndex;
    }

    // Function to sort the array using selection sort algorithm
    void selectionSort(int arr[], int n) {
        // Iterate over the entire array
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted part of the array
            int minIndex = select(arr, i);
            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}

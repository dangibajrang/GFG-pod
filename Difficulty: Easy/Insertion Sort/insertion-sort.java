//{ Driver Code Starts
import java.util.*;
import java.lang.Math;

class Sorting
{
	
	static void printArray(int arr[],int size)
	{
		int i;
		for(i=0;i<size;i++)
		System.out.print(arr[i]+" ");
	    System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
		
			for(int i=0;i<n;i++)
			a[i]= sc.nextInt();
			
			 new Solution().insertionSort(a,n);
			 printArray(a,n);
			
		t--;
		}
		
	}
}
// } Driver Code Ends

class Solution {
    // Function to insert an element at its correct position in the sorted part of the array
    static void insert(int arr[], int i) {
        // Store the element to be positioned
        int key = arr[i];
        // Initialize the previous index
        int j = i - 1;
        
        // Move elements of arr[0..i-1], that are greater than key,
        // to one position ahead of their current position
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        // Place the key at after the element just smaller than it.
        arr[j + 1] = key;
    }
    
    // Function to sort the array using insertion sort algorithm
    public void insertionSort(int arr[], int n) {
        // Traverse through 1 to n
        for (int i = 1; i < n; i++) {
            insert(arr, i);
        }
    }
}
 
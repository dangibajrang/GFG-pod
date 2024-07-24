//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

import java.util.LinkedList;
import java.util.Queue;

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
    { 
        // Queues for the positions of policemen and thieves
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thieves = new LinkedList<>();
        
        int caughtThieves = 0;

        // Populate the queues with initial positions
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }

        // Process the queues to catch thieves
        while (!police.isEmpty() && !thieves.isEmpty()) {
            int policePos = police.peek();
            int thiefPos = thieves.peek();

            if (Math.abs(policePos - thiefPos) <= k) {
                // Catch the thief
                caughtThieves++;
                police.poll(); // Remove this policeman from queue
                thieves.poll(); // Remove this thief from queue
            } else if (policePos < thiefPos) {
                // Current policeman cannot catch this thief, check next policeman
                police.poll();
            } else {
                // Current thief is out of reach, check next thief
                thieves.poll();
            }
        }

        return caughtThieves;
    }
    
    public static void main(String[] args) {
        // Example test case
        int n = 5;
        int k = 1;
        char arr[] = {'P', 'T', 'T', 'P', 'T'};
        
        System.out.println(catchThieves(arr, n, k)); // Output: 2
    }
}



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends
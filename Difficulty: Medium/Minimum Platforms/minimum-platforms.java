//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // Sort both the arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        // Platforms needed at the moment
        int platformsNeeded = 1;
        int maxPlatforms = 1;
        
        // Pointers for arrival and departure arrays
        int i = 1, j = 0;
        
        // Traverse the arrival and departure arrays
        while (i < n && j < n) {
            // If next event in sorted order is arrival, increment count of platforms needed
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                i++;
            }
            // If next event in sorted order is a departure, decrement count of platforms needed
            else {
                platformsNeeded--;
                j++;
            }
            
            // Update the maximum platforms needed
            if (platformsNeeded > maxPlatforms) {
                maxPlatforms = platformsNeeded;
            }
        }
        
        return maxPlatforms;
    }
}

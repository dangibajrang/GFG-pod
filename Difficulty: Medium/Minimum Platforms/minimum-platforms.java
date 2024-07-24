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

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        // Platforms needed at a time
        int platform_needed = 0;
        int max_platforms = 0;
        
        // Pointers for arrival and departure arrays
        int i = 0, j = 0;
        
        // Traverse through all arrival and departure times
        while (i < n && j < n) {
            // If next train is arriving before or at the same time as the current train departs
            if (arr[i] <= dep[j]) {
                platform_needed++;
                i++;
            } else {
                // If next train is departing before or at the same time as the current train arrives
                platform_needed--;
                j++;
            }
            // Update the maximum number of platforms needed
            max_platforms = Math.max(max_platforms, platform_needed);
        }
        
        return max_platforms;
    }
    
 
}



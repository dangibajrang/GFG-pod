//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String temp = arr[0];
        int i=0,j=0;
        while(i<temp.length()){
            for(j=0;j<arr.length;j++){
                if(temp.charAt(i)!=arr[j].charAt(i))break;
            }
            if(j!=arr.length)break;
            i++;
        }
        if(i==0)return "-1";
        return temp.substring(0,i);
    }
}
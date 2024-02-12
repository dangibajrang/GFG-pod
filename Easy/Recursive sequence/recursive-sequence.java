//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        // code here
        long ans = 1,mod = 1000000007,temp=2;
        int i=2;
        while(i<=n){
            int j = i;
            long temp2 = 1;
            while(j!=0){
                temp2*=temp;
                temp2%=mod;
                temp++;
                j--;
            }
            i++;
            ans+=temp2;
            ans%=mod;
        }
        return ans;
    }
}
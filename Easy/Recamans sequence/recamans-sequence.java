//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
         ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mm = new HashMap<>();
        ans.add(0);
        mm.put(0,1);
        for(int i=1;i<n;i++){
            if(ans.get(i-1)-i>0 && mm.get(ans.get(i-1)-i)==null){
                ans.add(ans.get(i-1)-i);
                mm.put(ans.get(i-1)-i,1);
            }
            else{
                ans.add(ans.get(i-1)+i);
                mm.put(ans.get(i-1)+i,1);
            }
        }
        return ans;
    }
}
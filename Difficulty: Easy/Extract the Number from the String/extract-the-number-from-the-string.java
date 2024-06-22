//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     long ExtractNumber(String sentence) {
        // code here
        long ans=0,temp=0;
        boolean indication=false;
        for(int i=0;i<sentence.length();i++){
            char x = sentence.charAt(i);
            if(x>='0' && x<='9'){
                if(x=='9')indication=true;
                temp=temp*10+(x-'0');
            }
            else if(x==' '){
                if(!indication)ans=Math.max(ans,temp);
                temp=0;
                indication=false;
            }
        }
        if(!indication)ans=Math.max(ans,temp);
        return ans==0?-1:ans;
    }
}
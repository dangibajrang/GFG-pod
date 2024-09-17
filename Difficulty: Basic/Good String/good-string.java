//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.isGoodString(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String isGoodString(String s) 
    { 
         // A string with length 1 is always good
        if (s.length() == 1) {
            return "YES";
        }
        // Loop through the string and compare adjacent characters
        for (int i = 1; i < s.length(); i++) {
            // Get the ASCII difference between the current and previous characters
            int difference = Math.abs(s.charAt(i) - s.charAt(i - 1));
            
            // If the difference is not 1, the string is not "Good"
            if (difference != 1 && difference != 25) {
                return "NO";
            }
        }
        
        // If all adjacent characters have a difference of 1, return "Good"
        return "YES";
    }
}

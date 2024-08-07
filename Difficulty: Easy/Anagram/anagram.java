//{ Driver Code Starts
import java.util.*;
import java.util.stream.*; 
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
          // If the lengths of the strings are not equal, they cannot be anagrams
        if (a.length() != b.length()) {
            return false;
        }
        
                // Create an array to count the frequency of each character
        int[] charCount = new int[26]; // Assuming only lowercase alphabets

        // Count the frequency of each character in the first string
        for (char c : a.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        
           // Subtract the frequency of each character in the second string
        for (char c : b.toCharArray()) {
            charCount[c - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;

        
    }
}
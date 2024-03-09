//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends

//User function Template for Java

class Solution {
    // Function to find the nth character after performing a specified operation on a string
    public char nthCharacter(String s, int r, int n) {
        // StringBuilder to store intermediate results during the operation
        StringBuilder temp = new StringBuilder();
        
        // Perform the operation 'r' times
        while (r != 0) {
            // Iterate through each character in the original string 's'
            for (int i = 0; i < s.length(); i++) {
                // Append "10" if the character is '1', otherwise append "01"
                if (s.charAt(i) == '1')
                    temp.append("10");
                else
                    temp.append("01");
                
                // Break if the length of the temporary string exceeds 'n'
                if (temp.length() > n)
                    break;
            }
            
            // Update the original string 's' with the contents of the temporary string
            s = temp.toString();
            
            // Clear the contents of the temporary string for the next iteration
            temp.setLength(0);
            
            // Decrement the operation count 'r'
            r--;
        }
        
        // Return the nth character in the final string after the specified operations
        return s.charAt(n);
    }
}

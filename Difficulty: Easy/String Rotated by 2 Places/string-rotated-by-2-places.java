//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String a, String b)
    {
        // Your code here
        if (a.length() != b.length()) {
            return false;
        
        }
        // If strings are shorter than 2 characters, they cannot be rotated by 2 places
        if (a.length() < 2) {
            return a.equals(b);
        }
        
        // Check anti-clockwise rotation
        String anticlockwiseRotation = a.substring(2) + a.substring(0, 2);
        
        // Check clockwise rotation
        String clockwiseRotation = a.substring(a.length() - 2) + a.substring(0, a.length() - 2);

        // Return true if either of the rotations matches string b
        return b.equals(anticlockwiseRotation) || b.equals(clockwiseRotation);
    }
    
}
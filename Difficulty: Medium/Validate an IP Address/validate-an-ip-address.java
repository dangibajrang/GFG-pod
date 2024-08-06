//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    public boolean isValid(String str) {
        // Split the string by dots
        String[] parts = str.split("\\.");
        
        // There should be exactly 4 parts
        if (parts.length != 4) {
            return false;
        }
        
        // Check each part
        for (String part : parts) {
            // Check if the part is a valid number
            if (!isValidPart(part)) {
                return false;
            }
        }
        
        // If all parts are valid, return true
        return true;
    }
    
    private boolean isValidPart(String part) {
        // Part should not be empty
        if (part.length() == 0) {
            return false;
        }
        
        // Check if the part contains only digits
        for (char c : part.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        // Convert part to integer
        int num = Integer.parseInt(part);
        
        // Check if the number is within the valid range
        if (num < 0 || num > 255) {
            return false;
        }
        
        // Check for leading zeros
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        
        return true;
    }
}

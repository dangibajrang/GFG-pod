//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        int originalNumber = n;
        int numberOfDigits = String.valueOf(n).length();
        int result = 0;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            result += Math.pow(digit, numberOfDigits);
            originalNumber /= 10;
        }

        return result == n ? "true" : "false";
    }
}

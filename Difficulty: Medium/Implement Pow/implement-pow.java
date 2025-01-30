//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java


// Here’s an optimized implementation of the power function using Exponentiation by Squaring for efficient calculation, with detailed comments explaining each step.

// Approach:
// 1.Handle Negative Exponents:
// If e is negative, compute 1 / power(b, -e).
// 2.Use Exponentiation by Squaring:
// If e is even: b^e = (b^(e/2)) * (b^(e/2))
// If e is odd: b^e = b * (b^(e-1))
// 3.Base Cases:
// If e == 0, return 1.
// If b == 0, return 0 (not needed per constraints).

class Solution {
    double power(double b, int e) {
        // Handle negative exponent by taking reciprocal
        if (e < 0) {
            b = 1 / b;
            e = -e;
        }
        
        double result = 1.0;
        double base = b; // Store initial base value
        
        while (e > 0) {
            // If exponent is odd, multiply result by base
            if ((e & 1) == 1) {
                result *= base;
            }
            // Square the base and halve the exponent
            base *= base;
            e /= 2;
        }
        
        return result;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends
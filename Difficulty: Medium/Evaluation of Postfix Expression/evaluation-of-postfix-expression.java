//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {
            if (isOperator(token)) {
                // Pop two operands
                int b = stack.pop();
                int a = stack.pop();
                
                // Compute result based on the operator
                int result = applyOperation(a, b, token);
                
                // Push result back to stack
                stack.push(result);
            } else {
                // Push number onto stack
                stack.push(Integer.parseInt(token));
            }
        }

        // Final result
        return stack.pop();
    }

    // Helper function to check if a token is an operator
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Helper function to apply operation
    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division (truncates towards zero)
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
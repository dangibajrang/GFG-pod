//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // Stack to store the indices of parentheses
        Stack<Integer> stack = new Stack<>();
        
        // Initialize the stack by pushing -1 (to handle edge cases)
        stack.push(-1);
        
        // Variable to store the maximum length of valid parentheses
        int maxLength = 0;
        
        // Loop through the string
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            // If it's an opening parenthesis, push its index onto the stack
            if (ch == '(') {
                stack.push(i);
            }
            // If it's a closing parenthesis
            else {
                // Pop the top element from the stack (the last opening parenthesis or unmatched closing parenthesis)
                stack.pop();
                
                // If the stack is not empty, calculate the valid substring length
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
                // If the stack is empty, push the current index as the base for the next valid substring
                else {
                    stack.push(i);
                }
            }
        }
        
        // Return the maximum valid parentheses length found
        return maxLength;
    }
    
}

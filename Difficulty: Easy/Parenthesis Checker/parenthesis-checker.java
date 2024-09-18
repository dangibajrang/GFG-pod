//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // Stack to store the opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse through each character of the expression
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            
            // If the character is an opening bracket, push it to the stack
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // If the character is a closing bracket
            else if (ch == '}' || ch == ')' || ch == ']') {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Check the top of the stack to see if it matches the closing bracket
                char top = stack.pop();
                if ((ch == '}' && top != '{') ||
                    (ch == ')' && top != '(') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If stack is empty, all brackets were matched; otherwise, unbalanced
        return stack.isEmpty();
    }

}

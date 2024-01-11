//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    public String removeKdigits(String S, int K) {
          Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            while (!stack.isEmpty() && stack.peek() > c && K > 0) {
                stack.pop(); //  stack  in ascending order
                K--;        // number of deletion remaining
            }

            // if (!stack.isEmpty()) {//push c irres of its 0 or not 
            //      stack.push(c);
            // } 
            // if(stack.isEmpty() && c!='0')
            // stack.push(c);
             
            //  if(stack.isEmpty() && c=='0') // no leading zeros
            //  continue;
            
            if(!stack.isEmpty() || c!='0')
             stack.push(c);
        }   
        // number of deletion remaining >0
        while (!stack.isEmpty() && K > 0) {
            stack.pop();
            K--;
        } 

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        // Appends characters one by one
        for (Character ch : stack) {
            sb.append(ch); //O(1)
        }

        return sb.toString();
    }
}
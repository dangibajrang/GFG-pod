//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends




class Solution {
    static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Build multi-digit number
            } else if (c == '[') {
                countStack.push(num); // Store repeat count
                stack.push(currentString.toString()); // Store current state
                currentString = new StringBuilder();
                num = 0; // Reset number
            } else if (c == ']') {
                StringBuilder decodedString = new StringBuilder(stack.pop());
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c); // Append letters
            }
        }
        return currentString.toString();
    }

}

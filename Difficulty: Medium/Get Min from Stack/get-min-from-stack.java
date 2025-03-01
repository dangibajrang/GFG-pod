//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public Solution() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        mainStack.push(x);
        // Push the minimum value onto minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // Pop the top element
    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    // Get the top element
    public int peek() {
        return mainStack.isEmpty() ? -1 : mainStack.peek();
    }

    // Retrieve the minimum element in O(1)
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}

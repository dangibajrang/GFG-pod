//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution g = new Solution();
            int ans = g.getMiddle(head);
            System.out.println(ans);
            // printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    // Function to find the middle of the linked list
    int getMiddle(Node head) {
        // If the list is empty, return -1
        if (head == null) {
            return -1;
        }

        // Initialize two pointers
        Node slow = head;
        Node fast = head;

        // Traverse the list, moving fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }

        // When the fast pointer reaches the end, slow will be at the middle
        return slow.data;
    }
}

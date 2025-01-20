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

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    Node reverseList(Node head) {
        // Initialize three pointers: previous, current, and next
        Node prev = null;       // This will eventually become the new head
        Node curr = head;       // Pointer to traverse the original list
        Node next = null;       // Temporarily stores the next node to avoid losing reference
        
        // Traverse the list until the current node becomes null
        while (curr != null) {
            // Step 1: Store the next node
            next = curr.next;
            
            // Step 2: Reverse the current node's pointer
            curr.next = prev;
            
            // Step 3: Move the previous pointer one step ahead
            prev = curr;
            
            // Step 4: Move the current pointer one step ahead
            curr = next;
        }
        
        // At the end of the loop, 'prev' will be the new head of the reversed list
        return prev;
    }
}

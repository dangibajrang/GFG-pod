//{ Driver Code Starts
/* package whatever; // don't place package name! */
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) { this.data = data; }
}

class Remove_Duplicate_From_LL {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t > 0) {
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            Node ans = ob.removeDuplicates(head);
            while (ans != null) {
                System.out.print(ans.data + " ");
                ans = ans.next;
            }
            System.out.println();

            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to remove duplicates from a sorted linked list.
    Node removeDuplicates(Node head) {
        // Edge case: if the list is empty
        if (head == null) {
            return head;
        }

        // Initialize the current pointer
        Node current = head;

        // Traverse the list
        while (current != null && current.next != null) {
            // Check if the current node's value is the same as the next node's value
            if (current.data == current.next.data) {
                // Skip the next node by pointing the current node's next to the next of next node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return head;
    }
}

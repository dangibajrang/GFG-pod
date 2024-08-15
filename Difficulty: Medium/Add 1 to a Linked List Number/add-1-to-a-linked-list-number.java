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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverse(head);
        
        // Step 2: Add one to the reversed list
        Node current = head;
        int carry = 1;
        Node prev = null;
        
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;  // Update the node with the new digit
            carry = sum / 10;          // Calculate carry for the next node
            
            prev = current;
            current = current.next;
        }
        
        // If there is still a carry after the last node, we need to add a new node
        if (carry > 0) {
            prev.next = new Node(carry);
        }
        
        // Step 3: Reverse the list again to restore the original order
        head = reverse(head);
        
        return head;
    }

    // Utility function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the link
            prev = current;       // Move prev to the current node
            current = next;       // Move to the next node in the original list
        }
        
        head = prev;  // Update the head to the last node (new head after reversal)
        return head;
    }
}

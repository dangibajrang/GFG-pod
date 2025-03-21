//{ Driver Code Starts
// Initial Template for Java

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


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
  
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        Node prev = null, tail = null, newHead = head;

        // Move `newHead` to the k-th node.
        for (int i = 0; i < k; i++) {
            prev = newHead;
            newHead = newHead.next;
        }

        // If `newHead` is null, k is the length of the list, return original head.
        if (newHead == null) {
            return head;
        }

        // Break the link between k-th node and (k+1)-th node.
        prev.next = null;
        tail = newHead;

        // Move `tail` to the end of the list.
        while (tail.next != null) {
            tail = tail.next;
        }

        // Connect the end of the list to the original head.
        tail.next = head;

        // Return the new head.
        return newHead;
    }
}



//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            String str2[] = read.readLine().trim().split(" ");

            int n = Integer.parseInt(str2[0]);
            int m = Integer.parseInt(str2[1]);
            new Solution().linkdelete(head, n, m);
            printList(head);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
delete n nodes after m nodes
The input list will have at least one element
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/
class Solution {
    static void linkdelete(Node head, int n, int m) {
        Node current = head;

        while (current != null) {
            // Skip M nodes
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }

            // If we have reached the end of the list
            if (current == null) {
                return;
            }

            // Delete N nodes
            Node temp = current.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            // Link the current node to the node after the N nodes
            current.next = temp;

            // Move to the next segment
            current = temp;
        }
    }
}


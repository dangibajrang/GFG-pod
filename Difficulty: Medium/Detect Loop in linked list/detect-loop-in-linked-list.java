//{ Driver Code Starts
//Initial template code for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class GFG
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            if( x.detectLoop(head) )
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/


class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        if (head == null) {
            return false; // No loop in an empty list
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by one
            fast = fast.next.next;  // Move fast pointer by two

            if (slow == fast) {     // If they meet, there's a loop
                return true;
            }
        }

        return false; // No loop found
    }

    // Helper function to create a linked list from an array
    public static Node createList(int[] arr, int pos) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;
        Node loopNode = null;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
            if (i == pos - 1) {
                loopNode = current;
            }
        }

        // Creating the loop if pos is not 0
        if (pos != 0) {
            current.next = loopNode;
        }

        return head;
    }

    // Main function to test the detectLoop method
    public static void main(String[] args) {
        int[][] testCases = {
            {3, 2, 1, 3, 4},
            {4, 0, 1, 8, 3, 4},
            {4, 1, 1, 2, 3, 4}
        };

        Solution sol = new Solution();

        for (int[] testCase : testCases) {
            int n = testCase[0];
            int pos = testCase[1];
            int[] values = new int[n];
            System.arraycopy(testCase, 2, values, 0, n);

            Node head = createList(values, pos);
            boolean result = sol.detectLoop(head);
            System.out.println(result);
        }
    }
}

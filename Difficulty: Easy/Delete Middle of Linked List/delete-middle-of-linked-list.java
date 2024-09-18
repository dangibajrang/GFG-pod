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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head);
        }
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    // Function to delete the middle node of a singly linked list.
    Node deleteMid(Node head) {
        // If the list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize pointers
        Node slow = head;
        Node fast = head;
        Node previous = null;

        // Traverse the list
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // `slow` is now pointing to the middle node (second middle if even)
        // `previous` is pointing to the node before the middle node

        // Delete the middle node
        if (previous != null) {
            previous.next = slow.next;
        }

        return head;
    }
}

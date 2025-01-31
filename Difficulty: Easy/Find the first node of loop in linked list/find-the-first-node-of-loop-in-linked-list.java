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

public class LinkedList {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
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
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);
            Solution ob = new Solution();
            Node ans = ob.findFirstNode(head);
            System.out.println(ans == null ? -1 : ans.data);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/* class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}*/
class Solution {
    public static Node findFirstNode(Node head) {
        if (head == null || head.next == null) return null; // No loop possible

        Node slow = head, fast = head;

        // Step 1: Detect Loop using Floyd’s Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by 1 step
            fast = fast.next.next;    // Move fast pointer by 2 steps

            if (slow == fast) { // Loop detected
                break;
            }
        }

        // If no loop exists, return -1
        if (slow != fast) return null;

        // Step 2: Find the first node of the loop
        slow = head; // Move slow pointer to head

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // This is the first node of the loop
    }
}


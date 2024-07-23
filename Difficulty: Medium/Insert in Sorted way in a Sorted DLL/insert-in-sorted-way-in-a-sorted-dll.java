//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        }

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/

class Solution {
    public Node sortedInsert(Node head, int x) {
        Node newNode = new Node(x);

        // Case 1: If the list is empty
        if (head == null) {
            return newNode;
        }

        // Case 2: If the new node needs to be inserted before the head
        if (x <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        Node current = head;

        // Traverse the list to find the insertion point
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        // Case 3: If the new node needs to be inserted at the end
        if (current.next == null) {
            current.next = newNode;
            newNode.prev = current;
        } else {
            // Case 4: Insert in between current and current.next
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
        }

        return head;
    }

    // Helper function to print the linked list
    void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Helper function to create a new node and append it to the end of the list
    Node append(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Creating a doubly linked list: 3 -> 5 -> 8 -> 10 -> 12
        Node head = null;
        head = solution.append(head, 3);
        head = solution.append(head, 5);
        head = solution.append(head, 8);
        head = solution.append(head, 10);
        head = solution.append(head, 12);

        System.out.print("Original List: ");
        solution.printList(head); // Output: 3 5 8 10 12

        // Inserting 9 into the sorted doubly linked list
        head = solution.sortedInsert(head, 9);
        
        System.out.print("After Inserting 9: ");
        solution.printList(head); // Output: 3 5 8 9 10 12
    }
}

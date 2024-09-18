//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            Solution obj = new Solution();
            Node[] newHeads = obj.mergeList(head1, head2);
            printList(newHeads[0]);
            printList(newHeads[1]);
        }
        sc.close();
    }
}

// } Driver Code Ends


/*
The structure of node class is :
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public Node[] mergeList(Node head1, Node head2) {
        // Initialize pointers
        Node current1 = head1;
        Node current2 = head2;

        // Traverse both lists and merge them alternately
        while (current1 != null && current2 != null) {
            Node next1 = current1.next; // Save next of current1
            Node next2 = current2.next; // Save next of current2
            
            // Insert current2 node into current1 node
            current1.next = current2;
            current2.next = next1; // Link next node of current2 to next1

            // Move to the next nodes
            current1 = next1;
            current2 = next2;
        }

        // If head2 has remaining nodes, they remain as they are
        // Return the modified lists as an array
        return new Node[]{head1, current2};
    }
}

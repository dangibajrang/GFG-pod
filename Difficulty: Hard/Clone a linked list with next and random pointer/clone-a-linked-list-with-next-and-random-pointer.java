//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null;
    }
}

class Cloning {

    public static Node addToTheLast(Node head, Node node) {
        if (head == null) {
            return node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
            return head;
        }
    }

    public static boolean validation(Node head, Node res) {
        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        if (len1 != len2) return false;

        HashMap<Node, Node> nodeMap = new HashMap<>();

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1 == temp2) return false;
            if (temp1.data != temp2.data) return false;

            if ((temp1.random == null && temp2.random != null) ||
                (temp1.random != null && temp2.random == null)) {
                return false;
            }
            if (temp1.random != null && temp2.random != null &&
                temp1.random.data != temp2.random.data) {
                return false;
            }
            nodeMap.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.random != null && nodeMap.get(temp1.random) != temp2.random) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline after the integer input

        while (t-- > 0) {
            Node head = null, head2 = null;
            String line = sc.nextLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = Arrays.stream(numsStr).mapToInt(Integer::parseInt).toArray();

            int n = nums.length;
            head = addToTheLast(head, new Node(nums[0]));
            head2 = addToTheLast(head2, new Node(nums[0]));

            for (int i = 1; i < n; i++) {
                head = addToTheLast(head, new Node(nums[i]));
                head2 = addToTheLast(head2, new Node(nums[i]));
            }

            String line2 = sc.nextLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] nums2 = Arrays.stream(numsStr2).mapToInt(Integer::parseInt).toArray();
            int q = nums2.length / 2;

            for (int i = 0; i < q; i++) {
                int a = nums2[2 * i];
                int b = nums2[2 * i + 1];

                Node tempA = head;
                Node temp2A = head2;
                for (int j = 0; j < a - 1 && tempA != null; j++) {
                    tempA = tempA.next;
                    temp2A = temp2A.next;
                }
                Node tempB = head;
                Node temp2B = head2;
                for (int j = 0; j < b - 1 && tempB != null; j++) {
                    tempB = tempB.next;
                    temp2B = temp2B.next;
                }

                if (a <= n) {
                    tempA.random = tempB;
                    temp2A.random = temp2B;
                }
            }

            Solution g = new Solution();
            Node res = g.copyList(head);

            if (validation(head, res) && validation(head2, res))
                System.out.println("true");
            else
                System.out.println("false");
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
class Node {
    int data;
    Node next, random;

    Node(int d)
    {
        data = d;
        next = random = null;

    }
}*/


class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // If the head is null, return null as there is nothing to copy
        if (head == null) return null;

        // Step 1: Create a copy of each node and insert it next to the original node
        Node current = head; // Start from the head of the original list
        while (current != null) {
            // Create a new node with the same data as the current node
            Node newNode = new Node(current.data);
            // Set the new node's next pointer to the current node's next pointer
            newNode.next = current.next;
            // Insert the new node right after the current node
            current.next = newNode;
            // Move to the next original node (skip the new node)
            current = newNode.next;
        }

        // Step 2: Set the random pointers for the new nodes
        current = head; // Reset current to the head of the original list
        while (current != null) {
            // If the original node has a random pointer, set the new node's random pointer
            if (current.random != null) {
                // The new node is the next of the current node
                current.next.random = current.random.next; // Set random pointer for the new node
            }
            // Move to the next original node (skip the new node)
            current = current.next.next;
        }

        // Step 3: Separate the new list from the original list
        Node newHead = head.next; // The head of the new copied list
        current = head; // Reset current to the head of the original list
        Node copyCurrent = newHead; // Start from the head of the copied list
        while (current != null) {
            // Restore the original list's next pointers
            current.next = current.next.next; // Restore the next pointer for the original list
            // If the next copied node exists, set its next pointer
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next; // Set next pointer for the copied list
            }
            // Move to the next original node and the next copied node
            current = current.next; // Move to the next original node
            copyCurrent = copyCurrent.next; // Move to the next copied node
        }

        // Return the head of the copied linked list
        return newHead;
    }
}


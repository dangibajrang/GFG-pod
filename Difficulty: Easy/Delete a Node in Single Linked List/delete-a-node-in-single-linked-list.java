//{ Driver Code Starts
import java.util.*;
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class DeleteNode
{
	Node head;
	void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	public void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;

		   temp.next = node;
		}}
	public static void main(String args[])
    {
       
         Scanner sc = new Scanner(System.in);
		 int t  =sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			DeleteNode llist = new DeleteNode();
			//int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			int x = sc.nextInt();
			//System.out.println(llist.head.data);
			  GfG g = new GfG(); 
			//System.out.println(k);
			//System.out.println(g.getNthFromLast(llist.head,k));
			Node result = g.deleteNode(llist.head, x);
			llist.printList(result);
		t--;
		}
	}
}
// } Driver Code Ends


/* Linklist node structure
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
/*You are required to complete below method*/


class GfG {
    Node deleteNode(Node head, int x) {
        if (head == null) {
            return null; // If the list is empty, nothing to delete
        }
        
        if (x == 1) {
            // If the node to be deleted is the head node
            return head.next;
        }
        
        // Find the node just before the one to be deleted
        Node current = head;
        for (int i = 1; i < x - 1; i++) {
            if (current == null || current.next == null) {
                return head; // If x is greater than the number of nodes, do nothing
            }
            current = current.next;
        }
        
        // If the node to be deleted is not the last node
        if (current != null && current.next != null) {
            current.next = current.next.next;
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

    // Helper function to create a new node and append it to the list
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
        return head;
    }

    public static void main(String[] args) {
        GfG list = new GfG();
        
        // Creating a linked list: 1 -> 3 -> 4
        Node head = null;
        head = list.append(head, 1);
        head = list.append(head, 3);
        head = list.append(head, 4);

        System.out.print("Original List: ");
        list.printList(head); // Output: 1 3 4

        // Deleting the 3rd node
        head = list.deleteNode(head, 3);
        
        System.out.print("After Deleting 3rd node: ");
        list.printList(head); // Output: 1 3

        // Creating another linked list: 1 -> 5 -> 2 -> 9
        head = null;
        head = list.append(head, 1);
        head = list.append(head, 5);
        head = list.append(head, 2);
        head = list.append(head, 9);

        System.out.print("Original List: ");
        list.printList(head); // Output: 1 5 2 9

        // Deleting the 2nd node
        head = list.deleteNode(head, 2);
        
        System.out.print("After Deleting 2nd node: ");
        list.printList(head); // Output: 1 2 9
    }
}


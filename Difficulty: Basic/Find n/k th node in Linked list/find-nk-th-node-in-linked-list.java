//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class LinkedList
{
    static Node head;
    
     public static void addToTheLast(Node node) 
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
		}
    }
    
     public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-- > 0)
		 {
		     int n = sc.nextInt();
		     int a1 = sc.nextInt();
		     Node head = new Node(a1);
		     addToTheLast(head);
		     for(int i = 1; i < n; i++)
		     {
		         int a = sc.nextInt(); 
				 addToTheLast(new Node(a));
			 }
			 int k = sc.nextInt();
			GfG gfg = new GfG();
			System.out.println(gfg.nknode(head, k));
		     }
		 }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/


class GfG {
    public static int nknode(Node head, int k) {
        if (head == null || k <= 0) {
            return -1; // Handle edge cases
        }

        // Step 1: Count the total number of nodes (N)
        int N = 0;
        Node current = head;
        while (current != null) {
            N++;
            current = current.next;
        }

        // Step 2: Calculate the position (ceil(N / k))
        int pos = (int) Math.ceil((double) N / k);

        // Step 3: Traverse the list to find the (N/k)-th node
        current = head;
        for (int i = 1; i < pos && current != null; i++) {
            current = current.next;
        }

        // Return the data of the (N/k)-th node
        if (current != null) {
            return current.data;
        } else {
            return -1; // If the position is out of bounds
        }
    }

    // Helper function to create a linked list from an array
    public static Node createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // Number of nodes in the list
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt(); // Value of k
            
            Node head = createList(arr);
            int result = nknode(head, k);
            System.out.println(result);
        }
        sc.close();
    }
}

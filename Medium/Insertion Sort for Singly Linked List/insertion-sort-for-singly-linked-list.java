//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
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
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
    
    
    class Solution
{
    public static Node insertionSort(Node head)
    {
        //code here
        Node ans =  new Node(head.data);
        Node curr=  head.next;
        while(curr!=null)
        {
            //store the next node
            Node next_node = curr.next;
            
            //traverse in ans list and insert the curr node to its right pos
            Node t1 = ans;
            Node preptr = null;
            while(t1!=null && t1.data < curr.data)
            {
                preptr = t1;
                t1=t1.next; 
            }
            //insert a node in starting
            if(preptr==null){
            curr.next=t1;
            ans = curr;
            }
            //at last
            else if(preptr.next==null){
                preptr.next=curr;
                curr.next=null;
            }
            //inserting in middle
            else{
                preptr.next = curr;
                curr.next =t1;
            }
            
            curr = next_node;
        }
        return ans;
    }
}

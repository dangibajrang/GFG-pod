//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
class BT_To_DLL
{
    
    static Node buildTree(String str)throws IOException{
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    

	void inorder(Node node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
	}
	public static void printList(Node head) 
    {
		Node prev = head;
        while (head != null) 
        {
            System.out.print(head.data + " ");
			prev = head;
            head = head.right;
        }
		
		System.out.println();
		while(prev != null)
		{
			System.out.print(prev.data+" ");
			prev = prev.left;
		}
    }
	public static void main(String args[])  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			    
			    Node ans = g.bToDLL(root);
			    printList(ans);
                t--;
                System.out.println();
	        }
			
		
	}
}

// } Driver Code Ends


//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution {
    
    // To keep track of the previous node in the in-order traversal
    Node prev = null;

    // Head of the DLL
    Node head = null;
    
    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root) {
        // If the tree is empty, return null
        if (root == null) {
            return null;
        }
        
        // Perform in-order traversal and update pointers
        convertToDLL(root);
        
        // Return the head of the DLL
        return head;
    }
    
    // Helper function to perform the in-order traversal and link nodes
    private void convertToDLL(Node root) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }
        
        // Recursively convert the left subtree
        convertToDLL(root.left);
        
        // Now process the current node (root)
        
        // If prev is null, it means we are at the leftmost node (head of DLL)
        if (prev == null) {
            // Set this node as the head of the doubly linked list
            head = root;
        } else {
            // If prev is not null, link the previous node with the current node
            prev.right = root;  // Set prev's right to current node
            root.left = prev;   // Set current node's left to prev node
        }
        
        // Move prev to the current node
        prev = root;
        
        // Recursively convert the right subtree
        convertToDLL(root.right);
    }
}

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[])
        {
            int ip[] = new int[2000];
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++)
                        {
                            ip[i] = sc.nextInt();
                        }
                        
                    Node root = null;
                    Solution obj = new Solution();
                    for(int i=0; i<n; i++)
                    {
                        root = obj.insertToAVL( root, ip[i] );
                        
                        if ( isBalancedBST(root) == false )
                            break;
                    }
                    
                    printInorder(root);
                    System.out.println();
                    
                }
            
                
        }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    int height;
};
*/


class Solution
{
    public  Node insertToAVL(Node node,int data)
    {
        //code here
        if(node==null) return new Node(data);
        if(data<node.data) node.left = insertToAVL(node.left,data);
        else node.right = insertToAVL(node.right,data);
        
        node.height = Math.max(height(node.left),height(node.right))+1;
        int diff = height(node.left)-height(node.right);
        
        if(diff>1){
            if(data<node.left.data) return rightRotation(node);
            else{
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }
        if(diff<-1){
            if(data>node.right.data) return leftRotation(node);
            else{
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }
        
        return node;
    }
    
    private int height(Node node){
        if(node==null) return 0;
        return node.height;
    }
    
    private Node leftRotation(Node node){
        Node r = node.right;
        Node rl = r.left;
        r.left = node;
        node.right = rl;
        
        node.height = Math.max(height(node.left),height(node.right))+1;
        r.height = Math.max(height(r.left),height(r.right))+1;
        
        return r;
    }
    
    private Node rightRotation(Node node){
        Node l = node.left;
        Node lr = l.right;
        l.right = node;
        node.left = lr;
        
        node.height = Math.max(height(node.left),height(node.right))+1;
        l.height = Math.max(height(l.left),height(l.right))+1;
        
        return l;
    }
}    
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution tr = new Solution();
            int sum = tr.findMaxSum(root);
            System.out.println(sum);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maxSum; // Stores the global maximum path sum

    // Function to return the maximum path sum from any node in the tree
    int findMaxSum(Node node) {
        maxSum = Integer.MIN_VALUE; // Initialize with smallest possible value
        maxPathSum(node); // Call helper function to compute max sum
        return maxSum; // Return the maximum sum found
    }

    // Helper function to compute max path sum recursively
    private int maxPathSum(Node node) {
        if (node == null) return 0; // Base case: if node is null, return 0

        // Recursively compute max sum for left and right subtrees
        int left = Math.max(0, maxPathSum(node.left)); // Ignore negative sums
        int right = Math.max(0, maxPathSum(node.right));

        // Compute max sum including the current node as the root of a path
        int currentSum = node.data + left + right;

        // Update global maxSum if current path sum is greater
        maxSum = Math.max(maxSum, currentSum);

        // Return the max path sum including the current node (extendable to parent)
        return node.data + Math.max(left, right);
    }
}


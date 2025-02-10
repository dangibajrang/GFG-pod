//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/


class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();

        if (node == null) return result;

        // Step 1: Add the root node (only if it's not a leaf node)
        if (!isLeaf(node)) {
            result.add(node.data);
        }

        // Step 2: Get Left Boundary (excluding leaf nodes)
        addLeftBoundary(node.left, result);

        // Step 3: Get Leaf Nodes (from left to right)
        addLeaves(node, result);

        // Step 4: Get Right Boundary (excluding leaf nodes, collected in reverse order)
        addRightBoundary(node.right, result);

        return result;
    }

    // Function to check if a node is a leaf node
    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    // Function to add left boundary excluding leaf nodes
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.data);
            }
            // Move left if possible, otherwise move right
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Function to add leaf nodes (in left-to-right order)
    private void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        // Recur for left and right subtree
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    // Function to add right boundary (in reverse order, excluding leaf nodes)
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.data); // Store in stack to reverse order
            }
            // Move right if possible, otherwise move left
            node = (node.right != null) ? node.right : node.left;
        }
        
        // Add right boundary nodes in reverse order
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
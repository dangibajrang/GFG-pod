//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/


class Solution {
    static int preIndex = 0;  // Tracks the current root in preorder traversal
    static HashMap<Integer, Integer> inorderMap;  // Stores indices for quick lookup

    public static Node buildTree(int inorder[], int preorder[]) {
        // Initialize preIndex and hashmap
        preIndex = 0;
        inorderMap = new HashMap<>();
        
        // Populate the map with inorder values and their indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // Build the tree using helper function
        return constructTree(preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int[] preorder, int inStart, int inEnd) {
        // Base Case: If start index > end index, return null
        if (inStart > inEnd) {
            return null;
        }
        
        // Pick the current root from preorder traversal
        int rootValue = preorder[preIndex++];
        Node root = new Node(rootValue);

        // Find the index of root in inorder
        int inIndex = inorderMap.get(rootValue);

        // Recursively construct the left and right subtrees
        root.left = constructTree(preorder, inStart, inIndex - 1);
        root.right = constructTree(preorder, inIndex + 1, inEnd);

        return root;
    }

    // Utility function to print postorder traversal
    public static void printPostorder(Node root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

}
//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
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

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
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

                // Create the right child for the curr node
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
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            ArrayList<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
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
    // Function to return a list of integers denoting the node values in sorted order.
    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> mergedList = new ArrayList<>();

        // Step 1: Get the in-order traversal of both BSTs
        inOrder(root1, list1);
        inOrder(root2, list2);

        // Step 2: Merge the two sorted lists
        mergeSortedLists(list1, list2, mergedList);

        return mergedList;
    }

    // Helper function to perform in-order traversal and store elements in a list
    private void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);  // Traverse left subtree
        list.add(root.data);        // Add root node
        inOrder(root.right, list); // Traverse right subtree
    }

    // Helper function to merge two sorted lists into one sorted list
    private void mergeSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> mergedList) {
        int i = 0, j = 0;
        int n = list1.size(), m = list2.size();

        // Merge both lists like merging two sorted arrays
        while (i < n && j < m) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements from list1
        while (i < n) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Add remaining elements from list2
        while (j < m) {
            mergedList.add(list2.get(j));
            j++;
        }
    }
}


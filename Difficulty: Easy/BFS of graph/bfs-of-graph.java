//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // List to store the result of the BFS traversal
        ArrayList<Integer> result = new ArrayList<>();
        
        // Array to keep track of visited nodes
        boolean[] visited = new boolean[V];
        
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Start BFS from node 0
        queue.add(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and add it to the result
            int node = queue.poll();
            result.add(node);
            
            // Get all adjacent vertices of the dequeued vertex
            for (int adjacent : adj.get(node)) {
                if (!visited[adjacent]) {
                    // If an adjacent vertex has not been visited, mark it visited and enqueue it
                    queue.add(adjacent);
                    visited[adjacent] = true;
                }
            }
        }
        
        return result;
    }
}

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Populate the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        // Distance array, initialized with -1
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        // BFS setup
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0;
        
        // BFS traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDist = dist[node];
            
            for (int neighbor : adjList.get(node)) {
                if (dist[neighbor] == -1) {  // If not visited
                    dist[neighbor] = currentDist + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return dist;
    }
    
 
}

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to return the minimum cost to reach the bottom right cell from the top left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        
        // Priority queue to store the cells based on the minimum cost encountered.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // Directions for moving up, down, left, right.
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // Distance array to keep track of the minimum cost to reach each cell.
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Start from the top-left corner.
        pq.add(new int[]{0, 0, grid[0][0]});
        dist[0][0] = grid[0][0];
        
        // Dijkstra's algorithm to find the minimum cost path.
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int currentCost = current[2];
            
            // If we have reached the bottom-right corner, return the cost.
            if (x == n - 1 && y == n - 1) {
                return currentCost;
            }
            
            // Explore the 4 possible directions.
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // Check if the new position is within bounds.
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int newCost = currentCost + grid[nx][ny];
                    
                    // If a cheaper path to the cell is found, update and push it into the queue.
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.add(new int[]{nx, ny, newCost});
                    }
                }
            }
        }
        
        // The code should never reach this point.
        return -1;
    }
}

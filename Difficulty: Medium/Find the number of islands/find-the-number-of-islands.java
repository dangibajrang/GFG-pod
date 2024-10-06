//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends


// class Solution {
//     // Define the 8 possible directions (horizontal, vertical, and diagonal)
//     private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
//     private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

//     public int numIslands(char[][] grid) {
//         // Edge case: if the grid is empty
//         if (grid == null || grid.length == 0) return 0;
        
//         int n = grid.length;     // number of rows
//         int m = grid[0].length;  // number of columns
//         int islandCount = 0;     // count of islands

//         // Iterate through every cell in the grid
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 // If we find a '1', it means we found a new island
//                 if (grid[i][j] == '1') {
//                     // Increase the island count
//                     islandCount++;
//                     // Perform DFS to mark the entire island
//                     dfs(grid, i, j, n, m);
//                 }
//             }
//         }
//         return islandCount;  // Return the total number of islands
//     }

//     // Helper method to perform DFS
//     private void dfs(char[][] grid, int x, int y, int n, int m) {
//         // Mark the current cell as visited by setting it to '0'
//         grid[x][y] = '0';

//         // Explore all 8 directions
//         for (int d = 0; d < 8; d++) {
//             int newX = x + dx[d];
//             int newY = y + dy[d];

//             // Ensure the new coordinates are valid and land ('1')
//             if (isValid(newX, newY, n, m) && grid[newX][newY] == '1') {
//                 dfs(grid, newX, newY, n, m);  // Perform DFS on the connected land
//             }
//         }
//     }

//     // Helper method to check if the coordinates are valid
//     private boolean isValid(int x, int y, int n, int m) {
//         return x >= 0 && x < n && y >= 0 && y < m;
//     }
// }




class Solution {
    // Direction array for moving in 8 possible directions (up, down, left, right, and diagonals)
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private int n, m; // Dimensions of the grid

    // Helper method to perform Iterative DFS and mark the current island
    private void solveIterative(char[][] grid, int startI, int startJ) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startI, startJ});
        grid[startI][startJ] = '0'; // Mark the start cell as visited
        
        // Continue until stack is empty
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];
            
            // Traverse all 8 possible directions
            for (int[] d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];
                
                // Check if the new coordinates are valid and land ('1')
                if (isValid(newX, newY, grid) && grid[newX][newY] == '1') {
                    stack.push(new int[]{newX, newY});
                    grid[newX][newY] = '0'; // Mark the new cell as visited
                }
            }
        }
    }

    // Helper method to check if the coordinates are valid
    private boolean isValid(int x, int y, char[][] grid) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // Main method to find the number of islands
    public int numIslands(char[][] grid) {
        // Get the dimensions of the grid
        n = grid.length;
        m = grid[0].length;
        int count = 0; // Counter for the number of islands

        // Traverse every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the current cell is land ('1'), perform Iterative DFS
                if (grid[i][j] == '1') {
                    solveIterative(grid, i, j); // Mark the entire island
                    count++; // Increment the island count
                }
            }
        }

        // Return the total number of islands
        return count;
    }
}


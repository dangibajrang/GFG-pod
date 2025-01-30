//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Steps to Solve the N-Queens Problem:
// Use Backtracking - Place queens one by one in different columns while ensuring they don’t attack each other.
// Track Placement - Maintain an array where the index represents the column, and the value represents the row where the queen is placed.
// Check Validity - Ensure that no two queens threaten each other by checking row and diagonal conflicts.
// Recursive Exploration - If a valid position is found, move to the next column. If all columns are filled, store the result.
// Backtrack if Needed - If no valid position is found for a queen, backtrack to the previous column and try a different row.




class Solution {
    // Function to find all solutions for the N-Queens problem
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // Result list to store all possible solutions
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Array to track the row placement of queens in each column
        int[] board = new int[n];
        
        // Start solving from the first column (index 0)
        solveNQueen(0, n, board, result);
        
        return result; // Return the final list of solutions
    }

    // Recursive function to place queens column by column
    private void solveNQueen(int col, int n, int[] board, ArrayList<ArrayList<Integer>> result) {
        // If all queens are placed successfully, store the solution
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // Since the problem asks for 1-based index, add 1 to each row index
                solution.add(board[i] + 1);
            }
            result.add(solution); // Add the valid configuration to result
            return; // Backtrack
        }

        // Try placing a queen in every row of the current column
        for (int row = 0; row < n; row++) {
            // Check if placing queen at (row, col) is safe
            if (isSafe(row, col, board)) {
                board[col] = row; // Place the queen
                
                // Recursively try placing the next queen in the next column
                solveNQueen(col + 1, n, board, result);
                
                // Backtracking: No need to explicitly reset board[col] as it will be overwritten in the next iteration
            }
        }
    }

    // Function to check if it's safe to place a queen at (row, col)
    private boolean isSafe(int row, int col, int[] board) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol]; // Row of queen placed in previous columns
            
            // Check if two queens are in the same row
            if (prevRow == row) return false;
            
            // Check if two queens are in the same diagonal
            if (Math.abs(prevRow - row) == Math.abs(prevCol - col)) return false;
        }
        return true; // If no conflicts, it's safe to place the queen
    }
}

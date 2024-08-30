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
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // Resultant list to store all possible solutions
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // An array to store the position of queens in each row
        int[] board = new int[n];
        
        // Initialize the board with -1, meaning no queen is placed
        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }
        
        // Start solving the N-Queen problem using backtracking from the first column
        solveNQueen(result, board, 0, n);
        
        return result;
    }
    
    private void solveNQueen(ArrayList<ArrayList<Integer>> result, int[] board, int col, int n) {
        // If all queens are placed, add the solution to the result list
        if (col == n) {
            addSolution(result, board, n);
            return;
        }
        
        // Try placing the queen in each row for the current column
        for (int i = 0; i < n; i++) {
            // Check if placing the queen at board[i] is safe
            if (isSafe(board, col, i)) {
                board[col] = i; // Place the queen
                solveNQueen(result, board, col + 1, n); // Recurse for the next column
                board[col] = -1; // Backtrack and remove the queen
            }
        }
    }
    
    // Helper method to check if placing a queen at board[row] is safe
    private boolean isSafe(int[] board, int col, int row) {
        // Check for conflicts with previously placed queens
        for (int i = 0; i < col; i++) {
            // Check if the row is occupied or if the queens are in the same diagonal
            if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
    
    // Helper method to add the current board configuration to the result
    private void addSolution(ArrayList<ArrayList<Integer>> result, int[] board, int n) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            solution.add(board[i] + 1); // Add 1 to match the problem's 1-indexed requirement
        }
        result.add(solution);
    }
}

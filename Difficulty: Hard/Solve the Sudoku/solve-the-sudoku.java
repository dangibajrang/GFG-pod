//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to solve the Sudoku
    static void solveSudoku(int[][] mat) {
        solve(mat); // Call the helper function to start solving
    }

    // Helper function to solve Sudoku using backtracking
    private static boolean solve(int[][] mat) {
        for (int row = 0; row < 9; row++) { // Loop through all rows
            for (int col = 0; col < 9; col++) { // Loop through all columns
                if (mat[row][col] == 0) { // If the cell is empty
                    for (int num = 1; num <= 9; num++) { // Try numbers 1-9
                        if (isValid(mat, row, col, num)) { // Check if the number is valid
                            mat[row][col] = num; // Place the number

                            if (solve(mat)) { // Recursively try solving with this number
                                return true; // If successful, return true
                            }

                            mat[row][col] = 0; // Backtrack (reset cell to empty)
                        }
                    }
                    return false; // If no number works, backtrack
                }
            }
        }
        return true; // If no empty cells remain, the Sudoku is solved
    }

    // Function to check if placing 'num' in mat[row][col] is valid
    private static boolean isValid(int[][] mat, int row, int col, int num) {
        // Check if 'num' exists in the row
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num) return false;
        }

        // Check if 'num' exists in the column
        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == num) return false;
        }

        // Check if 'num' exists in the 3x3 sub-grid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[startRow + i][startCol + j] == num) return false;
            }
        }

        return true; // If 'num' is valid, return true
    }

    // Function to print the solved Sudoku grid
    static void printGrid(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

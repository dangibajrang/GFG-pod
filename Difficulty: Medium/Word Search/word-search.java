//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public static boolean isWordExist(char[][] mat, String word) {
        int n = mat.length, m = mat[0].length;

        // Step 1: Traverse the matrix to find the first letter of the word
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the first letter of the word matches, start DFS search
                if (mat[i][j] == word.charAt(0) && dfs(mat, word, i, j, 0, n, m)) {
                    return true;
                }
            }
        }
        return false; // Word not found
    }

    // DFS function to check if word exists
    private static boolean dfs(char[][] mat, String word, int i, int j, int index, int n, int m) {
        // Step 2: If all characters are matched, return true
        if (index == word.length()) {
            return true;
        }

        // Step 3: Check boundary conditions and if the current character matches
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] != word.charAt(index)) {
            return false;
        }

        // Step 4: Mark cell as visited (temporary change)
        char temp = mat[i][j];
        mat[i][j] = '#'; // Mark as visited

        // Step 5: Explore all 4 possible directions (up, down, left, right)
        boolean found = dfs(mat, word, i - 1, j, index + 1, n, m) ||  // Up
                        dfs(mat, word, i + 1, j, index + 1, n, m) ||  // Down
                        dfs(mat, word, i, j - 1, index + 1, n, m) ||  // Left
                        dfs(mat, word, i, j + 1, index + 1, n, m);    // Right

        // Step 6: Backtrack (restore original character)
        mat[i][j] = temp;

        return found; // Return true if word is found in any direction
    }

}

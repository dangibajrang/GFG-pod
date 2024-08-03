//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int ans=-1,j=0,n=mat.length;
        for(int i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(mat[i][j]==1)break;
            }
            if(j==n){
                for(j=0;j<n;j++){
                    if(i!=j && mat[j][i]==0)break;
                }
                if(j==n)ans=i;
                break;
            }
        }
        return ans;
    }
}
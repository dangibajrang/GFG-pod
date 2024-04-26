//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
         int i=0,j=0,previ=0,prevj=0,face=0;
        while(i<n && i>=0 && j>=0 && j<m){
            previ=i;
            prevj=j;
            if(matrix[i][j]==1){
                matrix[i][j]=0;
                if(face==0){
                    i++;
                    face=1;
                }
                else if(face==1){
                    j--;
                    face=2;
                }
                else if(face==2){
                    i--;
                    face=3;
                }
                else{
                    j++;
                    face=0;
                }
            }
            else{
                if(face==0)j++;
                else if(face==1)i++;
                else if(face==2)j--;
                else i--;
            }
        }
        int ans[] = new int[2];
        ans[0]=previ;
        ans[1]=prevj;
        return ans;
    }
}
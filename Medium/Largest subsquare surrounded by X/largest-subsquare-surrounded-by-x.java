//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            char A[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) A[i][j] = S[j].charAt(0);
            }
            Solution ob = new Solution();
            System.out.println(ob.largestSubsquare(N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int largestSubsquare(int n, char a[][]) {
        // code here
        int left[][] = new int[n][n];
        int top[][] = new int[n][n];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]=='X'){
                    if(i!=0){
                        top[i][j]=top[i-1][j]+1;
                    }
                    else top[i][j]=1;
                    if(j!=0){
                        left[i][j]=left[i][j-1]+1;
                    }
                    else left[i][j]=1;
                }
                int minX=Math.min(top[i][j],left[i][j]);
                while(minX!=0){
                    int k = j-minX+1;
                    int l = i-minX+1;
                    if(top[i][k]>=minX && left[l][j]>=minX){
                        ans=Math.max(ans,minX);
                        break;
                    }
                    minX--;
                }
            }
        }
        return ans;
    }
};
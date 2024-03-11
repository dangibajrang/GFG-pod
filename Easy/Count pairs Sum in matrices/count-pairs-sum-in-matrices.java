//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        
        int i=0,j=0,k=n-1,l=n-1,ans=0;
	    while(i<n && j<n && k>=0 && l>=0){
	        if(mat1[i][j]+mat2[k][l]==x){
	            ans++;
	            if(j==n-1){
	                j=0;
	                i++;
	            }
	            else j++;
	            if(l==0){
	                l=n-1;
	                k--;
	            }
	            else l--;
	        }
	        else if(mat1[i][j]+mat2[k][l]>x){
	            if(l==0){
	                l=n-1;
	                k--;
	            }
	            else l--;
	        }
	        else{
	            if(j==n-1){
	                j=0;
	                i++;
	            }
	            else j++;	            
	        }
	    }
	    return ans;


    }
}
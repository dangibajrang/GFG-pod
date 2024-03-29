//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int max_courses(int n, int total, int[] cost) {
        // code here
        Integer [][] dp = new Integer [n][total+1];
        return chec(cost,0,total,dp);
        
    }
    static int chec(int[] cost,int ind, int total, Integer[][] dp){
        if(cost.length ==ind)
            return 0;
            
        if(dp[ind][total] != null){
            return dp[ind][total];
        }
        if(total >= cost[ind]){
            int price  = cost[ind] -((9*cost[ind])/10);
            return dp[ind][total] =Math.max(1+chec(cost,ind+1,total-price,dp),chec(cost,ind+1,total,dp));
        }
        return dp[ind][total] = chec (cost,ind+1,total,dp);
        
    }
}


//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends



class Solution {
    long max_Books(int arr[], int n, int k) {
        // Your code here
        long ans=0,sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)sum+=arr[i];
            else{
                ans=Math.max(ans,sum);
                sum=0;
            }
        }
        ans=Math.max(sum,ans);
        return ans;
    }
}
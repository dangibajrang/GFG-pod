//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
     static int ans=0;
    int help(ArrayList<ArrayList<Integer>> adj,int vis[],int node){
        vis[node]=1;
        int size=1;
        for(int x:adj.get(node)){
            if(vis[x]==0){
                int temp = help(adj,vis,x);
                size+=temp;
                if(temp%2==0)ans++;
            }
        }
        return size;
    }
    public int minimumEdgeRemove(int n, int[][] edges) {
        // code here
        ans=0;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int x[]:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
	    int vis[] = new int[n+1];
	    Arrays.fill(vis,0);
	    for(int i=1;i<=n;i++){
	        if(vis[i]==0){
	            int temp = help(adj,vis,i);
	        }
	    }
	    return ans;
    }

}

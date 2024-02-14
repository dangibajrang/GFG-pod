//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
      static int timer=1;
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> ans,int lowtime[],int parent){
        lowtime[node]=timer;
        int parentTime=timer;
        timer++;
        for(int x:adj.get(node)){
            if(x==parent)continue;
            else if(lowtime[x]==0){
                dfs(x,adj,ans,lowtime,node);
            }
            lowtime[node]=Math.min(lowtime[node],lowtime[x]);
            if(parentTime<lowtime[x]){
                ArrayList<Integer> temp = new ArrayList<>();
                if(node<x){
                    temp.add(node);
                    temp.add(x);
                }
                else{
                    temp.add(x);
                    temp.add(node);
                }
                ans.add(temp);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	    int lowtime[] = new int[v];
	    Arrays.fill(lowtime,0);
	    timer=1;
	    dfs(0,adj,ans,lowtime,-1);
	    Collections.sort(ans,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                if(a.get(0)-b.get(0)==0)return a.get(1)-b.get(1);
                return a.get(0)-b.get(0);
            }
        });
	    return ans;
    }
}
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

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        Queue<int[]> q=new LinkedList<>();
        int vis[][] = new int[rows][columns];
        for(int temp[]:vis){
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        int x[]={-1,0,1,0};
        int y[]={0,1,0,-1};
        int temp[]={0,0,0};
        q.add(temp);
        while(q.size()!=0){
            temp = q.remove();
            int i=temp[1];
            int j = temp[2];
            int dis = temp[0];
            for(int k=0;k<4;k++){
                int newi=i+x[k];
                int newj=j+y[k];
                if(newi>=0 && newi<rows && newj>=0 && newj<columns){
                    int newd=Math.max(dis,Math.abs(heights[newi][newj]-heights[i][j]));
                    if(newd<vis[newi][newj]){
                        int newArray[] = {newd,newi,newj};
                        q.add(newArray);
                        vis[newi][newj]=newd;
                    }
                }
            }
        }
        return vis[rows-1][columns-1]!=Integer.MAX_VALUE?vis[rows-1][columns-1]:0;

    }
}

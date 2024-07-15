//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        StringBuilder ans = new StringBuilder();
        int i=1;
        while(i<=d){
            int num = s-(d-i)*9<=0?0:s-(d-i)*9;
            if(num>9)return "-1";
            if(i==1 && num==0)num=1;
            ans.append((char)(num+'0'));
            s-=num;
            i++;
        }
        return ans.toString();

    }
}

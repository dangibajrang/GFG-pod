//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
        vector<vector<long long>> help(long long m,vector<vector<long long>> &mat1,vector<vector<long long>> &mat2){
        vector<vector<long long>> ans(mat1.size(), vector<long long>(mat1.size(), 0));
        for (int i = 0; i < mat1.size(); i++) {
            for (int j = 0; j < mat1.size(); j++) {
                for (int k = 0; k < mat1.size(); k++) {
                    ans[i][j] += (mat1[i][k]%m*mat2[k][j]%m)%m;
                    ans[i][j] %= m;
                }
            }
        }
        return ans;
    } 
    long long genFibNum(long long a, long long b, long long c, long long n, long long m) {
        // code here
        if(n==1 or n==2)return 1%m;
        vector<vector<long long>> relation = {{a,b,c},{1,0,0},{0,0,1}};
        vector<vector<long long>> result = {{1,0,0},{0,1,0},{0,0,1}};
        n-=2;
        while(n){
            if(n&1){
                result = help(m,relation,result);
            }
            relation = help(m,relation,relation);
            n/=2;
        }
        return (result[0][0]+result[0][1]+result[0][2])%m;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long a,b,c,n,m;
        
        cin>>a>>b>>c>>n>>m;

        Solution ob;
        cout << ob.genFibNum(a,b,c,n,m) << endl;
    }
    return 0;
}
// } Driver Code Ends
//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int arr[], int n)
    {
        // code here 
        int l =0 ;
        int mid = 0;
        int r =n-1;
        while(mid<=r){
            if(arr[mid] ==0){
                int temp =arr[l];
                arr[l] =arr[mid];
                arr[mid] =temp;
                mid++;
                l++;
                
            }else if(arr[mid] == 1){
                mid++;
            }else {
                int temp =arr[r];
                arr[r]=arr[mid];
                arr[mid]=temp;
                r--;
            }
        }
        return;
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends
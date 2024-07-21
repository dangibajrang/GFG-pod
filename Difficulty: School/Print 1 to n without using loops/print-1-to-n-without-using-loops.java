//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ob.printTillN(N);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static void printTillN(int N){
        // code here
              // Start the recursive process with 1
        printNumbers(1, N);

    }

    // Helper method to handle the recursion
    private static void printNumbers(int current, int N) {
        // Base case: if current is greater than N, stop recursion
        if (current > N) {
            return;
        }

        // Print the current number followed by a space
        System.out.print(current + " ");

        // Recursive call to print the next number
        printNumbers(current + 1, N);
    

    }
}
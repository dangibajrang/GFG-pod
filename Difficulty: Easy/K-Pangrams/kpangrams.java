//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean kPangram(String str, int k) {
        // Step 1: Initialize an array to track the presence of each character
        int[] arr = new int[26];
        int n = str.length();
        int ch = 0;

        // Step 2: Iterate through the string and update the presence array
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ' ') {
                arr[str.charAt(i) - 'a'] = 1;
                ch++;
            }
        }

        // Step 3: Count how many characters are missing
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                c++;
            }
        }

        // Step 4: Determine if we can make the string a pangram
        if (ch < 26 || c > k) return false;
        return true;
    }
}


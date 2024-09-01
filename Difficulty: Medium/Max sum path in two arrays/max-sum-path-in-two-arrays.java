//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends
class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // Initialize pointers for both arrays
        int i = 0, j = 0;
        
        // Initialize sums and maximum sum
        int sum1 = 0, sum2 = 0, maxSum = 0;
        
        // Traverse both arrays
        while (i < arr1.size() && j < arr2.size()) {
            // If elements are equal, switch paths
            if (arr1.get(i).equals(arr2.get(j))) {
                // Update maxSum with the maximum path sum before the common element
                maxSum += Math.max(sum1, sum2) + arr1.get(i);
                
                // Reset sums
                sum1 = 0;
                sum2 = 0;
                
                // Move both pointers
                i++;
                j++;
            } else if (arr1.get(i) < arr2.get(j)) {
                // Add to sum1 and move pointer i
                sum1 += arr1.get(i);
                i++;
            } else {
                // Add to sum2 and move pointer j
                sum2 += arr2.get(j);
                j++;
            }
        }
        
        // Add remaining elements from arr1 to sum1
        while (i < arr1.size()) {
            sum1 += arr1.get(i);
            i++;
        }
        
        // Add remaining elements from arr2 to sum2
        while (j < arr2.size()) {
            sum2 += arr2.get(j);
            j++;
        }
        
        // Final update of maxSum
        maxSum += Math.max(sum1, sum2);
        
        return maxSum;
    }
}

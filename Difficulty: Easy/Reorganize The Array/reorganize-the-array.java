//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        int n = arr.size();

        // Rearranging the array in place
        for (int i = 0; i < n; i++) {
            // While the current element is not -1 and it's not in the correct position,
            // we swap it with the element at its target position (arr[i] < n ensures valid index)
            while (arr.get(i) != -1 && arr.get(i) != i && arr.get(i) < n) {
                // Get the value at the target position
                int targetIdx = arr.get(i);
                
                // Swap only if it's different from the current index and it's valid
                if (arr.get(targetIdx) != targetIdx) {
                    // Swap arr[i] with arr[targetIdx]
                    int temp = arr.get(i);
                    arr.set(i, arr.get(targetIdx));
                    arr.set(targetIdx, temp);
                } else {
                    break; // Prevent infinite loop for duplicate values
                }
            }
        }

        // After the swapping phase, make sure that elements that aren't in the correct position are set to -1
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i) {
                arr.set(i, -1);
            }
        }

        return arr;
    

    
  }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends
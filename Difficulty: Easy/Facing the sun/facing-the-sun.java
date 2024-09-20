//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputStrings = input.split(" ");
            int[] height = new int[inputStrings.length];
            for (int i = 0; i < inputStrings.length; i++) {
                height[i] = Integer.parseInt(inputStrings[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countBuildings(height);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    // Returns count of buildings that can see the sunrise
    public int countBuildings(int[] height) {
        // Step 1: Initialize the count to 1 because the first building always sees the sunrise
        int count = 1;

        // Step 2: Keep track of the maximum height encountered so far (first building height)
        int maxHeight = height[0];

        // Step 3: Loop through the array starting from the second building
        for (int i = 1; i < height.length; i++) {
            // Step 4: If the current building is taller than the max height seen so far
            if (height[i] > maxHeight) {
                // Step 5: Increment the count as this building can see the sunrise
                count++;
                // Step 6: Update the max height to the current building's height
                maxHeight = height[i];
            }
        }

        // Step 7: Return the total count of buildings that can see the sunrise
        return count;
    }
}

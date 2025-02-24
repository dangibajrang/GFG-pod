//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    PriorityQueue<Integer> left;  // Max heap
    PriorityQueue<Integer> right; // Min heap
    
    public Solution() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();
        
        for (int num : arr) {
            addNumber(num);
            result.add(findMedian());
        }
        
        return result;
    }

    private void addNumber(int num) {
        left.offer(num); // Add to max heap

        // Move the max of left to right to maintain order
        right.offer(left.poll());

        // Balance sizes: left heap should always have >= right heap size
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    private double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

}

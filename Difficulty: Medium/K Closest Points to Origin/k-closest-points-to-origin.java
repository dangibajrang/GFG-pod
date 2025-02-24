//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

// use a Max-Heap (PriorityQueue) to keep track of the K closest points.

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap to store the k closest points (farther points get removed)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a)) // Sort by farthest first
        );

        // Add each point to the heap
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove farthest point
            }
        }

        // Convert heap to an array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    // Helper function to compute squared distance from origin
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

  
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends
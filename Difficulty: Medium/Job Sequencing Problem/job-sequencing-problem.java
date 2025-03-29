//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends



class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        
        // Step 1: Create a list of jobs (each job contains deadline and profit)
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }
        
        // Step 2: Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        // Step 3: Find the maximum deadline to create a scheduling array
        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }
        
        // Step 4: Use an array to track the available time slots
        int[] schedule = new int[maxDeadline + 1]; // Index represents time slots
        Arrays.fill(schedule, -1); // -1 means the slot is empty

        int maxProfit = 0, jobCount = 0;

        // Step 5: Iterate over sorted jobs and schedule them
        for (Job job : jobs) {
            // Find an available slot from job.deadline to 1
            for (int j = job.deadline; j > 0; j--) {
                if (schedule[j] == -1) { // If slot is available
                    schedule[j] = job.profit; // Assign job to this slot
                    maxProfit += job.profit;
                    jobCount++;
                    break;
                }
            }
        }

        // Return the number of jobs scheduled and the total maximum profit
        return new ArrayList<>(Arrays.asList(jobCount, maxProfit));
    }

    // Helper class to store job information
    static class Job {
        int deadline, profit;
        Job(int d, int p) {
            this.deadline = d;
            this.profit = p;
        }
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends
//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends
class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs by profit in descending order
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        
        // Array to keep track of free time slots
        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);
        
        int countJobs = 0;
        int maxProfit = 0;
        
        // Iterate through all jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (starting from the last possible slot)
            for (int j = arr[i].deadline; j > 0; j--) {
                if (slots[j] == -1) {
                    // Slot is free, assign the job to this slot
                    slots[j] = arr[i].id;
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[]{countJobs, maxProfit};
    }
}


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
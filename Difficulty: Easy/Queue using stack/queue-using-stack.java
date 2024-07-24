//{ Driver Code Starts
import java.util.*;


class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queue g = new Queue();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.enqueue(a);
				}
				else if(QueryType == 2)
				System.out.print(g.dequeue()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}


// } Driver Code Ends
class Queue {
    Stack<Integer> input = new Stack<Integer>(); 
    Stack<Integer> output = new Stack<Integer>(); 
    
    // Method to push element into the queue
    void enqueue(int x) {
        input.push(x);
    }
    
    // Method to pop the element out of the queue
    int dequeue() {
        // If both stacks are empty, return -1 indicating queue is empty
        if (input.isEmpty() && output.isEmpty()) {
            return -1;
        }
        
        // If output stack is empty, transfer elements from input stack to output stack
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        
        // Return the top element from the output stack
        return output.pop();
    }



}


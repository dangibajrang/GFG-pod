class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a stack to keep indexes
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that have freq <= current element's freq
            while (!stack.isEmpty() && freq.get(arr[stack.peek()]) <= freq.get(arr[i])) {
                stack.pop();
            }

            // If stack is empty, no element with higher freq on right
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = arr[stack.peek()];
            }

            // Push current index to stack
            stack.push(i);
        }

        // Convert array to ArrayList
        for (int num : res) {
            result.add(num);
        }

        return result;
    }
}

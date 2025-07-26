class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        // Traverse the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentIndex = i % n;

            // Pop elements that are less than or equal to current element
            while (!stack.isEmpty() && stack.peek() <= arr[currentIndex]) {
                stack.pop();
            }

            // If stack is not empty, the top is the next greater element
            if (!stack.isEmpty()) {
                result.set(currentIndex, stack.peek());
            }

            // Push current element to stack
            stack.push(arr[currentIndex]);
        }

        return result;
    }
}

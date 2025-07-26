class Solution {
    public int maxSum(int arr[]) {
        int maxSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int sum = a + b;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}

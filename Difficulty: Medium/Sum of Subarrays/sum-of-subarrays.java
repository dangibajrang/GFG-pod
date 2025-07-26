class Solution {
    public int subarraySum(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        // Traverse each element to calculate its contribution
        for (int i = 0; i < n; i++) {
            // Number of subarrays that include arr[i]
            int startChoices = i + 1;     // Number of starting positions
            int endChoices = n - i;       // Number of ending positions
            int contribution = arr[i] * startChoices * endChoices;

            totalSum += contribution;
        }

        return totalSum;
    }
}

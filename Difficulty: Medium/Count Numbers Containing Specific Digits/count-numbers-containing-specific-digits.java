class Solution {
    public int countValid(int n, int[] arr) {
        // Step 1: Mark forbidden digits from arr[]
        boolean[] isForbidden = new boolean[10];
        for (int digit : arr) {
            isForbidden[digit] = true;
        }

        // Step 2: Build allowed digits (not in arr[])
        List<Integer> allowed = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            if (!isForbidden[i]) {
                allowed.add(i);
            }
        }

        // Step 3: Total n-digit numbers = 9 * 10^(n - 1)
        int totalNumbers = (int) Math.pow(10, n) - (int) Math.pow(10, n - 1);

        // Step 4: Count how many n-digit numbers can be formed using only allowed digits
        int validWithoutArr = countUsingAllowedDigits(allowed, n);

        // Step 5: Final result = total - numbers without any arr[] digit
        return totalNumbers - validWithoutArr;
    }

    // Helper to count n-digit numbers using only allowed digits
    private int countUsingAllowedDigits(List<Integer> allowed, int n) {
        if (allowed.isEmpty()) return 0;

        int count = 0;
        // For first digit: cannot be 0
        for (int first : allowed) {
            if (first == 0) continue;
            count += countHelper(allowed, n - 1);
        }

        return count;
    }

    // Helper: number of ways to fill (n - 1) digits from allowed digits
    private int countHelper(List<Integer> allowed, int len) {
        return (int) Math.pow(allowed.size(), len);
    }
}

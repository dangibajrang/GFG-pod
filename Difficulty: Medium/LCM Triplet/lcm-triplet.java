class Solution {
    // Helper method to calculate GCD (used in LCM calculation)
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper method to calculate LCM of two numbers
    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // Main function to find the maximum LCM of any 3 numbers ≤ n
    int lcmTriplets(int n) {
        if (n <= 2) return n; // For n = 1 or 2, LCM is n itself
        long maxLCM = 0;

        // Try all triplets from n, n-1, ..., n-4
        for (long i = n; i >= Math.max(1, n - 4); i--) {
            for (long j = i; j >= Math.max(1, n - 4); j--) {
                for (long k = j; k >= Math.max(1, n - 4); k--) {
                    long currentLCM = lcm(lcm(i, j), k);
                    maxLCM = Math.max(maxLCM, currentLCM);
                }
            }
        }
        return (int) maxLCM;
    }
}

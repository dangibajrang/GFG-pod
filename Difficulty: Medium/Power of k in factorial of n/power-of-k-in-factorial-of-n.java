class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = getPrimeFactors(k);
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int powerInK = entry.getValue();
            int countInFactorial = countPrimeInFactorial(n, prime);
            result = Math.min(result, countInFactorial / powerInK);
        }

        return result;
    }

    // Function to count how many times `prime` occurs in n!
    private int countPrimeInFactorial(int n, int prime) {
        int count = 0;
        while (n > 0) {
            n /= prime;
            count += n;
        }
        return count;
    }

    // Function to get prime factorization of k with their powers
    private Map<Integer, Integer> getPrimeFactors(int k) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            factors.put(k, 1);  // k itself is a prime
        }
        return factors;
    }
}

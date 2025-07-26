class Solution {
    public static int countNumbers(int n) {
        int limit = (int) Math.sqrt(n) + 1;
        List<Integer> primes = sieve(limit);
        int count = 0;

        // Case 1: p^8
        for (int p : primes) {
            long num = 1;
            for (int i = 0; i < 8; i++) num *= p;
            if (num <= n) count++;
            else break; // p^8 is increasing very fast
        }

        // Case 2: p^2 * q^2 (p != q)
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long p2 = (long) primes.get(i) * primes.get(i);
            if (p2 > n) break;
            for (int j = i + 1; j < size; j++) {
                long q2 = (long) primes.get(j) * primes.get(j);
                long num = p2 * q2;
                if (num <= n) count++;
                else break;
            }
        }

        return count;
    }

    // Sieve of Eratosthenes
    private static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (isPrime[i]) primes.add(i);

        return primes;
    }
}

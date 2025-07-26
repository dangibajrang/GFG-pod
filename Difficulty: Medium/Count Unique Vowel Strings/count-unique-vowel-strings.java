class Solution {
    public int vowelCount(String s) {
        // Set of vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Map to count occurrences of each vowel
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequencies of vowels in the string
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        // If no vowels found
        if (freq.size() == 0) return 0;

        // Multiply the number of choices for each vowel
        int totalWays = 1;
        for (int count : freq.values()) {
            totalWays *= count;
        }

        // Multiply by factorial of number of distinct vowels (for permutations)
        totalWays *= factorial(freq.size());

        return totalWays;
    }

    // Helper function to compute factorial
    private int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

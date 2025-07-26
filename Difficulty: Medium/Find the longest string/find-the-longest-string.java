class Solution {
    public String longestString(String[] words) {
        // Store all words in a set for O(1) lookup
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        // Sort the words by decreasing length and lexicographically
        Arrays.sort(words, (a, b) -> {
            if (b.length() != a.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        for (String word : words) {
            boolean isValid = true;
            // Check all prefixes of the current word
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                if (!wordSet.contains(prefix)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return word; // First valid word is the longest with all prefixes
        }

        return ""; // If no such word found
    }
}

class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add current character to the map
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            // If window size exceeds k, remove the leftmost character
            if (i >= k) {
                char toRemove = s.charAt(i - k);
                freqMap.put(toRemove, freqMap.get(toRemove) - 1);
                if (freqMap.get(toRemove) == 0) {
                    freqMap.remove(toRemove);
                }
            }

            // If window size == k, check distinct count
            if (i >= k - 1) {
                if (freqMap.size() == k - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Solution {
    public int totalElements(int[] arr) {
        // Map to store the frequency of elements in the current window
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        int left = 0, right = 0;
        int maxLen = 0;

        // Slide the right pointer through the array
        while (right < arr.length) {
            int current = arr[right];
            // Add current element to frequency map
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);

            // If more than 2 distinct elements, shrink the window from the left
            while (freqMap.size() > 2) {
                int leftVal = arr[left];
                freqMap.put(leftVal, freqMap.get(leftVal) - 1);
                
                // If frequency becomes 0, remove the element from the map
                if (freqMap.get(leftVal) == 0) {
                    freqMap.remove(leftVal);
                }
                left++; // shrink the window
            }

            // Update the maximum length of valid window
            maxLen = Math.max(maxLen, right - left + 1);
            right++; // expand the window
        }

        return maxLen;
    }
}

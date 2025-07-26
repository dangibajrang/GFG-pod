class Solution {
    public int countAtMostK(int arr[], int k) {
        if (k == 0) return 0;

        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;

        for (right = 0; right < arr.length; right++) {
            // Include arr[right] in the window
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            // If distinct elements exceed k, shrink the window from left
            while (freqMap.size() > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++; // shrink from the left
            }

            // All subarrays ending at 'right' and starting from 'left' to 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }
}

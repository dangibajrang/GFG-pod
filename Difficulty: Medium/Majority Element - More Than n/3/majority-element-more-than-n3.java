
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;

        // Step 1: Initialize two potential candidates and their counts
        int candidate1 = Integer.MIN_VALUE, count1 = 0;
        int candidate2 = Integer.MIN_VALUE, count2 = 0;

        // Step 2: First pass to find two possible candidates
        for (int num : arr) {
            if (num == candidate1) {
                // If num matches candidate1, increment count1
                count1++;
            } else if (num == candidate2) {
                // If num matches candidate2, increment count2
                count2++;
            } else if (count1 == 0) {
                // If count1 is zero, assign num to candidate1
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                // If count2 is zero, assign num to candidate2
                candidate2 = num;
                count2 = 1;
            } else {
                // Otherwise, decrement both counts
                count1--;
                count2--;
            }
        }

        // Step 3: Reset counts to verify actual occurrences
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        // Step 4: Prepare the result list based on floor(n / 3) condition
        ArrayList<Integer> result = new ArrayList<>();
        int threshold = n / 3;
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        // Step 5: Sort the result as required
        Collections.sort(result);
        return result;
    }
}

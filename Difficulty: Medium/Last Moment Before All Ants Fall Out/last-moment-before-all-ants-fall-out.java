class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;

        // For ants moving to the left, time to fall = position itself
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }

        // For ants moving to the right, time to fall = n - position
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }
}

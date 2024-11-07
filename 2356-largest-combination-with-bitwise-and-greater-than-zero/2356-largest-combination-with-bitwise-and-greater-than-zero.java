class Solution {
    public int largestCombination(int[] candidates) {
        int maxSize = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            maxSize = Math.max(maxSize, count);
        }
        return maxSize;
    }
}
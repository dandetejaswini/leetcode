class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            boolean[] seen = new boolean[k];

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                if (nums[j] - min < k) {
                    seen[nums[j] - min] = true;
                }
            }

            boolean isConsecutive = true;
            for (boolean s : seen) {
                if (!s) {
                    isConsecutive = false;
                    break;
                }
            }

            results[i] = isConsecutive ? max : -1;
        }
        return results;
    }
}
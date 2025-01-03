class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int validSplits = 0;
        long leftSum = 0;
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            if (leftSum >= totalSum - leftSum) {
                validSplits++;
            }
        }

        return validSplits;
    }
}
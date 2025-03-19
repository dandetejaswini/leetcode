class Solution {
    public int minOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                operations++;
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
            }
        }

        for (int num : nums) {
            if (num == 0) {
                return -1;
            }
        }

        return operations;
    }
}
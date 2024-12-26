class Solution {
    private HashMap<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return findWays(nums, 0, target);
    }

    private int findWays(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        
        String key = index + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = findWays(nums, index + 1, target - nums[index]);
        int subtract = findWays(nums, index + 1, target + nums[index]);

        memo.put(key, add + subtract);
        return add + subtract;
    }
}
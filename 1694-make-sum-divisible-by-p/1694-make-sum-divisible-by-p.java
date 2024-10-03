class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        
        
        if (totalSum == 0) return 0;
        
        int targetMod = totalSum;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);  
        int prefixSum = 0;
        int minLength = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int neededMod = (prefixSum - targetMod + p) % p;
            
            if (prefixMap.containsKey(neededMod)) {
                minLength = Math.min(minLength, i - prefixMap.get(neededMod));
            }
            
            prefixMap.put(prefixSum, i);
        }
        
        return minLength == nums.length ? -1 : minLength;
    }
}
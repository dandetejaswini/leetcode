class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        long long count = 0;
        long long sum = 0;
        int left = 0;
        int n = nums.size();
        
        for (int right = 0; right < n; ++right) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        
        return count;
    }
};
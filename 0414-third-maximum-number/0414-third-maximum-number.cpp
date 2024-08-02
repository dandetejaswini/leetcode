class Solution {
public:
    int thirdMax(vector<int>& nums) {
        sort(nums.begin(), nums.end(), std::greater<int>());
        int count = 1;
        int prev = nums[0];
        
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] < prev) {
                prev = nums[i];
                count++;
            }
            if (count == 3) {
                return nums[i];
            }
        }
        
        return nums[0];
    }
};
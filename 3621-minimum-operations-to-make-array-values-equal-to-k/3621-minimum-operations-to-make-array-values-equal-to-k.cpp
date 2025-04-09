class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        unordered_set<int> distinct_greater_values;
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                distinct_greater_values.insert(num);
            }
        }
        return distinct_greater_values.size();
    }
};
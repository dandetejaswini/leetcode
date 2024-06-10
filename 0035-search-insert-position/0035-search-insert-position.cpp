class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int l = 0, h = size(nums) - 1 , mid;
        while(l <= h){
             mid = (l+h)/2;
        // for(int i=0; i<nums.size(); i++){
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                   h = mid - 1;
            }
            else{
                l = mid + 1;
            }
      }
        return l;
    }
};

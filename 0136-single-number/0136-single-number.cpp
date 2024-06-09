class Solution {
public:
    int singleNumber(vector<int>& nums) {
        //xor (^) both bits are same--> false, otherwise true
      //  vector<int> vec;
        int num=0;
         for(int i=0; i<size(nums); i++){
           (num ^= nums[i]);
    }
    return num;
    }
};
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> target = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        return target.stream().mapToInt(i -> i).toArray();
    }
}
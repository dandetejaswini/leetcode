class Solution {
    public int maxArea(int[] height) {
         int i = 0, j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            int width = j - i;
            int height1 = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, width * height1);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
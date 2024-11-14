class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = Arrays.stream(quantities).max().getAsInt();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int storesNeeded = 0;
            
            for (int quantity : quantities) {
                storesNeeded += (quantity + mid - 1) / mid;
            }
            
            if (storesNeeded <= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
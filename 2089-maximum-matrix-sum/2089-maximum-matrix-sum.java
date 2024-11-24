class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    negativeCount++;
                }
                sum += Math.abs(num);
                minAbsValue = Math.min(minAbsValue, Math.abs(num));
            }
        }

        if (negativeCount % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * minAbsValue;
        }
    }
}
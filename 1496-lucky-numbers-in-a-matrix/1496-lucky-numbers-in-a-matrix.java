class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
         List<Integer> luckyNumbers = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int minRow = matrix[i][0];
            int minColIndex = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minRow) {
                    minRow = matrix[i][j];
                    minColIndex = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][minColIndex] > minRow) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                luckyNumbers.add(minRow);
            }
        }

        return luckyNumbers;
    }
}
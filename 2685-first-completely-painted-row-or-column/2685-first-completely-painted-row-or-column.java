class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[] rowPainted = new boolean[m];
        boolean[] colPainted = new boolean[n];
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        HashMap<Integer, int[]> positionMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] pos = positionMap.get(arr[i]);
            if (pos != null) {
                int row = pos[0];
                int col = pos[1];
                rowCount[row]++;
                colCount[col]++;
                
                if (rowCount[row] == n) {
                    return i;
                }
                if (colCount[col] == m) {
                    return i;
                }
            }
        }
        return -1;
    }
}
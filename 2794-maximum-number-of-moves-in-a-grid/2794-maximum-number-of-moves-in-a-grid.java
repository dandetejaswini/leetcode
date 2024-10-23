class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxMoves = 0;
        int[][] dp = new int[m][n];
        
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (j < n - 1) {
                    if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) 
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
                    if (grid[i][j] < grid[i][j + 1]) 
                        dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                    if (i < m - 1 && grid[i][j] < grid[i + 1][j + 1]) 
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                }
                if (j == 0) maxMoves = Math.max(maxMoves, dp[i][j]);
            }
        }
        return maxMoves;
    }
}
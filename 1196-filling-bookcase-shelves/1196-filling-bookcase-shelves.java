class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
         int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int width = 0, maxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) break;
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + maxHeight);
            }
        }
        return dp[n];
    }
}
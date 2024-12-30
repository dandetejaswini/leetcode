class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 0; i <= high; i++) {
            if (i + zero <= high) {
                dp[i + zero] = (dp[i + zero] + dp[i]) % MOD;
            }
            if (i + one <= high) {
                dp[i + one] = (dp[i + one] + dp[i]) % MOD;
            }
        }

        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % MOD;
        }

        return result;
    }
}
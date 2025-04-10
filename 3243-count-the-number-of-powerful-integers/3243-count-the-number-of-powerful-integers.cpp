class Solution {
public:
    long long numberOfPowerfulInt(long long start, long long finish, int limit, string s) {
        long long suffix = stoll(s);
        int suffix_len = s.length();
        long long ten_pow = 1;
        for (int i = 0; i < suffix_len; ++i) {
            ten_pow *= 10;
        }
        long long min_N = suffix;
        if (min_N > finish) {
            return 0;
        }
        
        long long max_prefix = (finish - suffix) / ten_pow;
        if (max_prefix < 0) {
            return 0;
        }
        
        long long min_prefix = (start - suffix + ten_pow - 1) / ten_pow; 
        if (start > suffix) {
            min_prefix = max(min_prefix, 0LL);
        } else {
            min_prefix = 0;
        }
        
        if (min_prefix > max_prefix) {
            return 0;
        }
        return count_numbers_with_digits_leq_limit(max_prefix, limit) - 
               count_numbers_with_digits_leq_limit(min_prefix - 1, limit);
    }
    
private:
    long long count_numbers_with_digits_leq_limit(long long n, int limit) {
        if (n < 0) return 0;
        string s = to_string(n);
        int m = s.length();
        vector<vector<long long>> dp(m, vector<long long>(2, -1));
        return dfs(0, true, s, limit, dp);
    }
    
    long long dfs(int pos, bool tight, const string& s, int limit, vector<vector<long long>>& dp) {
        if (pos == s.length()) {
            return 1;
        }
        if (dp[pos][tight] != -1) {
            return dp[pos][tight];
        }
        long long res = 0;
        int max_digit = tight ? (s[pos] - '0') : 9;
        max_digit = min(max_digit, limit);
        for (int d = 0; d <= max_digit; ++d) {
            bool new_tight = tight && (d == (s[pos] - '0'));
            res += dfs(pos + 1, new_tight, s, limit, dp);
        }
        dp[pos][tight] = res;
        return res;
    }
};
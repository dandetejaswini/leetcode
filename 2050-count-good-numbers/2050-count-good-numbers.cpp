class Solution {
public:
    int countGoodNumbers(long long n) {
        const int MOD = 1e9 + 7;
        long long even_positions = (n + 1) / 2;
        long long odd_positions = n / 2;
        
        auto power = [MOD](long long base, long long exp) -> long long {
            long long result = 1;
            base = base % MOD;
            while (exp > 0) {
                if (exp % 2 == 1) {
                    result = (result * base) % MOD;
                }
                base = (base * base) % MOD;
                exp = exp / 2;
            }
            return result;
        };
        
        long long even_choices = power(5, even_positions);
        long long odd_choices = power(4, odd_positions);
        
        return (even_choices * odd_choices) % MOD;
    }
};
class Solution {
    public char findKthBit(int n, int k) {
         if (n == 1) return '0';
        int length = (1 << n) - 1; // Length of Sn is 2^n - 1
        int mid = length / 2 + 1; // Middle index of Sn
        
        if (k == mid) return '1'; // The middle bit is always '1'
        if (k < mid) return findKthBit(n - 1, k); // If k is in the first half
        return invert(findKthBit(n - 1, length - k + 1)); // If k is in the second half
    }
    
    private char invert(char c) {
        return c == '0' ? '1' : '0';
    }
}
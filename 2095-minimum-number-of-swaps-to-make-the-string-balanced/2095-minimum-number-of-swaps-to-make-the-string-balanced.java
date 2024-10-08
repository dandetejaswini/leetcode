class Solution {
    public int minSwaps(String s) {
        int balance = 0, maxBalance = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                balance--;
            }
            maxBalance = Math.min(maxBalance, balance);
        }
        return (Math.abs(maxBalance) + 1) / 2;
    }
}
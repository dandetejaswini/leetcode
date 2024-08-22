class Solution {
    public int bitwiseComplement(int n) {
            if(n == 0)
            return 1;
        int pow = (int)(Math.log(n)/Math.log(2)) +1;
        int val = (int)(Math.pow(2,pow)) - 1;
        int ans = n ^ val;
        return ans;
    }
}
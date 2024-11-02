class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; 
            freq[remainder]++;
        }
        
        
        for (int i = 1; i < (k + 1) / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        
        if (freq[0] % 2 != 0) {
            return false;
        }
        
       
        if (k % 2 == 0 && freq[k / 2] % 2 != 0) {
            return false;
        }
        
        return true;
    }
}
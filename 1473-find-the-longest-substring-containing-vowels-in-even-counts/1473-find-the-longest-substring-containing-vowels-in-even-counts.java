class Solution {
    public int findTheLongestSubstring(String s) {
          int[] index = new int[1 << 5]; 
        Arrays.fill(index, -2); 
        index[0] = -1;
        int mask = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a': mask ^= 1 << 0; break;
                case 'e': mask ^= 1 << 1; break;
                case 'i': mask ^= 1 << 2; break;
                case 'o': mask ^= 1 << 3; break;
                case 'u': mask ^= 1 << 4; break;
            }
            if (index[mask] == -2) {
                index[mask] = i; 
            }
            maxLength = Math.max(maxLength, i - index[mask]);
        }
        return maxLength;
    }
}
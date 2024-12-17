class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        while (true) {
            int idx = -1;
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) break;

            int toAdd = Math.min(count[idx], repeatLimit);
            for (int i = 0; i < toAdd; i++) {
                result.append((char) (idx + 'a'));
            }
            count[idx] -= toAdd;

            if (count[idx] > 0) {
                int nextIdx = -1;
                for (int i = idx - 1; i >= 0; i--) {
                    if (count[i] > 0) {
                        nextIdx = i;
                        break;
                    }
                }
                if (nextIdx == -1) break;
                result.append((char) (nextIdx + 'a'));
                count[nextIdx]--;
            }
        }
        return result.toString();
    }
}
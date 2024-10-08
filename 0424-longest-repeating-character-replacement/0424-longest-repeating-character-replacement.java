class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0, left = 0, maxLength = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(s.charAt(right)));

            while (right - left + 1 - maxCount > k) {
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
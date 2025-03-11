class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);

            while (countMap.size() == 3) {
                result += s.length() - right;
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                if (countMap.get(s.charAt(left)) == 0) {
                    countMap.remove(s.charAt(left));
                }
                left++;
            }
        }
        return result;
    }
}
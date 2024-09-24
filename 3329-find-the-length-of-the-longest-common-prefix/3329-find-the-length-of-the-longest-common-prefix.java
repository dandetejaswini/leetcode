class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> prefixes = new HashSet<>();
        int maxLength = 0;

        for (int num : arr1) {
            String strNum = String.valueOf(num);
            for (int i = 1; i <= strNum.length(); i++) {
                prefixes.add(strNum.substring(0, i));
            }
        }

        for (int num : arr2) {
            String strNum = String.valueOf(num);
            for (int i = 1; i <= strNum.length(); i++) {
                String prefix = strNum.substring(0, i);
                if (prefixes.contains(prefix)) {
                    maxLength = Math.max(maxLength, prefix.length());
                }
            }
        }

        return maxLength;
    }
}
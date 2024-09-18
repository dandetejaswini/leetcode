class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }
        int start = 0;
        while (start < result.length() && result.charAt(start) == '0') {
            start++;
        }
        if (start == result.length()) {
            return "0";
        }
        return result.substring(start);
    }
}
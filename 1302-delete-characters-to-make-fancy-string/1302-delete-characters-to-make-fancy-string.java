class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count = (i > 0 && s.charAt(i) == s.charAt(i - 1)) ? count + 1 : 1;
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
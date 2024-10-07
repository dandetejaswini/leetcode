class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean found = true;

        while (found) {
            found = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                String substring = sb.substring(i, i + 2);
                if (substring.equals("AB") || substring.equals("CD")) {
                    sb.delete(i, i + 2);
                    found = true;
                    break;
                }
            }
        }
        
        return sb.length();
    }
}
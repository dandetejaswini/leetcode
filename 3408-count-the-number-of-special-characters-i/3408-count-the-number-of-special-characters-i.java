class Solution {
    public int numberOfSpecialChars(String word) {
         HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower.add(c);
            } else if (Character.isUpperCase(c)) {
                upper.add(Character.toLowerCase(c));
            }
        }
        
        lower.retainAll(upper);
        return lower.size();
    }
}
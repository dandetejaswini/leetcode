class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> Anagram = new HashMap<>();

        for(String i : strs){
            char Arr[] = i.toCharArray();
            Arrays.sort(Arr);
            String s = new String(Arr);

            if(!Anagram.containsKey(s)){
                 Anagram.put(s,new ArrayList<>());
                 }
// System.out.println(Anagram.values());
            Anagram.get(s).add(i);
        }
        return new ArrayList<>(Anagram.values());
    }
}
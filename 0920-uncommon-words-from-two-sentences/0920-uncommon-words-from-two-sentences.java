class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
       HashSet<String> uncommon = new HashSet<>();
        HashSet<String> common = new HashSet<>();

        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        for (String e1 : arr1){
            if (common.contains(e1)){
                continue;
            }
            else if (uncommon.contains(e1)){
                // remove from uncommon
                // add to common
                uncommon.remove(e1);
                common.add(e1);
            }
            else{
                // add to uncommon
                uncommon.add(e1);
            }
        }

        for (String e1 : arr2){
            if (common.contains(e1)){
                continue;
            }
            else if (uncommon.contains(e1)){
                // remove from uncommon
                // add to common
                uncommon.remove(e1);
                common.add(e1);
            }
            else{
                // add to uncommon
                uncommon.add(e1);
            }
        }

        String[] res = uncommon.toArray(new String[uncommon.size()]);

        return res;
    }
}
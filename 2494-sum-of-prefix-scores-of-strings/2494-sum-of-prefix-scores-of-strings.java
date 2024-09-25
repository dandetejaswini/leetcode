class Solution {
     class TrieNode {
        int count;
        TrieNode[] children;

        TrieNode() {
            count = 0;
            children = new TrieNode[26];
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.count++;
        }
    }

    public int[] sumPrefixScores(String[] words) {
         TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }

        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char c : words[i].toCharArray()) {
                node = node.children[c - 'a'];
                result[i] += node.count;
            }
        }
        return result;
    }
}
package trie;

/**
 * 208. 实现 Trie (前缀树)
 *
 * 只处理小写英文字母 a-z
 */
public class Solution {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private final TrieNode root;

    public Solution() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String text) {
        TrieNode node = root;
        for (int i = 0; i < text.length(); i++) {
            int idx = text.charAt(i) - 'a';
            if (idx < 0 || idx >= 26 || node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }

    public static void main(String[] args) {
        Solution trie = new Solution();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}

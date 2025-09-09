package ca.bytetube._09_trie;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        if (word == null) return;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }

        node.end++;

    }

    public int search(String word) {
        if (word == null) return 0;

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) return 0;
            node = node.nexts[index];
        }

        return node.end;

    }


    public int prefix(String pre) {
        if (pre == null) return 0;
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) return 0;
            node = node.nexts[index];
        }
        return node.path;

    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts[index].path == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }

            node.end--;
        }


    }


    private static class TrieNode {
        int path;
        int end;
        TrieNode[] nexts;

        public TrieNode() {
            this.nexts = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bce", "bef", "abd", "abcd"};
        Trie trie = new Trie();
        for (String s : strings) {
            trie.add(s);
        }
        int prefixCount = trie.prefix("abc");

        trie.delete("abc");
        int wordCount = trie.search("abc");
        System.out.println(prefixCount);

    }
}

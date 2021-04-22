package leetcode.tag.tree.Trie;

/**
 * P211 211. 添加与搜索单词 - 数据结构设计
 */
public class P211_WordDictionary {
    TrieNode root;

    public P211_WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean searchPrefix(TrieNode node, String word, int i) {
        if (i >= word.length()) {
            return node.isEnd();
        }

        char ch = word.charAt(i);
        if (ch != '.') {
            if (node.containsKey(ch)) {
                return searchPrefix(node.get(ch), word, i+1);
            }else {
                return true;
            }
        }else {
            TrieNode[] links = node.getAllLinks();
            boolean present = false;
            for(TrieNode n : links) {
                if (n != null) {
                    present = present || searchPrefix(n, word, i+1);
                }
            }
            return present;
        }
    }

    public boolean search(String word) {
        TrieNode node = root;
        return searchPrefix(root, word, 0);
    }

    // 自定义前缀树
    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;
        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch-'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public TrieNode[] getAllLinks() {
            return links;
        }


    }
}

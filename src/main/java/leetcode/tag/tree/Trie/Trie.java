package leetcode.tag.tree.Trie;

import java.util.Arrays;

/**
 * P208 前缀树
 */
public class Trie {
    // 子节点的指针数组
    private Trie[] children;
    // 表示该节点是否为字符串的结尾
    private boolean isEnd;

    public Trie() {
        children = new Trie[26]; // 26 为本场景下的字母表的大小
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        // 重复步骤。直到处理字符串的最后一个字符
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            // 如果子节点不存在。
            // 创建一个新的子节点，记录在children数组的对应位置上，然后沿着指针移动到子节点
            // 继续搜索下一个字符。
            if(node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        // 然后，将当前节点标记为字符串的结尾
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "children=" + Arrays.toString(children) +
                ", isEnd=" + isEnd +
                '}';
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");
        System.out.println(apple);
        System.out.println(trie);
    }
}

package leetcode.tag.tree.Trie;

public class P208_Trie_1 {
    // 指向子节点的指针
    private P208_Trie_1[] children;
    // 是否是一个key的末尾
    private boolean isEnd;

    public P208_Trie_1() {
        children = new P208_Trie_1[26];
        isEnd = false;
    }

    // 将一个字符串插入 前缀树
    public void insert(String word) {
        P208_Trie_1 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new P208_Trie_1();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // 判断word是否在前缀树中
    public  boolean search(String word) {
        P208_Trie_1 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // 查找一个关键字
    public P208_Trie_1 searchPrefix(String prefix) {
        P208_Trie_1 node = this;
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

    public static void main(String[] args) {
        P208_Trie_1 trie = new P208_Trie_1();
        trie.insert("hello");
        boolean param_2 = trie.search("hello");
        boolean param_3 = trie.search("world");
        System.out.println(param_2);
        System.out.println(param_3);
    }

}

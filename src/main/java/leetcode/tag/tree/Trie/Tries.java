package leetcode.tag.tree.Trie;

public abstract class Tries {
    private Tries[] children;
    private boolean isEnd;



    /**
     * 将字符串插入前缀树中
     * @param word
     */
    public abstract void insert(String word);

    /**
     * 判断前缀树中是否有字符串以 指定的prefix 为前缀
     * @param prefix
     * @return 若有一个字符串以prefix为前缀则返回true
     */
    public abstract boolean startsWith(String prefix);

    /**
     * 判断字符串是否在前缀树中
     * @param word
     * @return
     */
    public abstract boolean search(String word);


    /**
     * 查找返回一个 包含指定word前缀的节点
     * @param word
     * @return
     */
    public abstract Tries searchPrefix(String word);
}

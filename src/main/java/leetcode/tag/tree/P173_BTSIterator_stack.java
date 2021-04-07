package leetcode.tag.tree;

import java.util.Deque;
import java.util.LinkedList;

public class P173_BTSIterator_stack {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public P173_BTSIterator_stack(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext(){
        return cur != null || !stack.isEmpty();
    }
}

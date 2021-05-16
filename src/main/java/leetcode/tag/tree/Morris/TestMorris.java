package leetcode.tag.tree.Morris;

import leetcode.tag.tree.TreeNode;

public class TestMorris {

    public void morris(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            // 1. 找到左字数的最右界定啊
            pre = cur.left;
            if(pre != null) {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur; // 连接左子树的最右节点  和 cur
                    cur = cur.left; // 移动cur，让cur向左
                    continue;
                } else {
                    pre.right = null;
                }
            }
        }

    }
}

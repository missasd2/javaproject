package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树——层序遍历_递归
 */
public class P102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){
        // 按层遍历
        // 1.
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;

        // 2. 单层的处理
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root); //
        while (!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = nodes.remove(0);
                list.add(remove.val);
                if (remove.left != null){
                    nodes.add(remove.left);
                }
                if (remove.right != null){
                    nodes.add(remove.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }



}

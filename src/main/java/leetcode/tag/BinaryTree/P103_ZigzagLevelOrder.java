package leetcode.tag.BinaryTree;

import edu.princeton.cs.algs4.Stack;

import java.util.LinkedList;
import java.util.List;

public class P103_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        list1.addLast(root);
        while (!list1.isEmpty()){
            LinkedList<Integer> item = new LinkedList<>();
            while (!list1.isEmpty()){
                TreeNode temp = list1.removeLast(); // 尾取
                // 头插入
                if (temp.left != null) list2.addFirst(temp.left);
                if (temp.right != null) list2.addFirst(temp.right);
                item.add(temp.val);
            }
            res.add(item);
            LinkedList<TreeNode> tmp =new LinkedList<TreeNode>();
            tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        return res;

    }
}

package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树——层序遍历_双队列形式
 */
public class P102_LevelOrder_TwoList {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // 当前节点
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        // 用于记录下一层的所有节点
        LinkedList<TreeNode> queue2 = new LinkedList<>();


        queue1.offer(root);
        while (!queue1.isEmpty()){
            List<Integer> item = new ArrayList<>();


            // 对当前节点进行内循环
            while (!queue1.isEmpty()){

                TreeNode node = queue1.remove();
                item.add(node.val);
                if (node.left != null){
                    queue2.offer(node.left);
                }
                if (node.right != null){
                    queue2.offer(node.right);
                }
            }
            res.add(item);

            // queue1 和 queue2 进行交换
            LinkedList<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }



        return res;
    }



}

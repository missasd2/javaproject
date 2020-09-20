package leetcode.tag.Tree;

import leetcode.tag.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历 BFS 双队列
 */
public class P102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        queue1.add(root);

        // 外循环
        while ( !queue1.isEmpty()){

            List<Integer> list = new ArrayList<Integer>();

            // 内循环
            while ( !queue1.isEmpty()){
                TreeNode curr = queue1.poll();
                if ( curr.left != null){
                    queue2.add(curr.left);
                }
                if (curr.right != null){
                    queue2.add(curr.right);
                }

                list.add(curr.val);

            }
            res.add(list);
            Queue<TreeNode> tmp = new LinkedList<>();
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        return res;
    }
}

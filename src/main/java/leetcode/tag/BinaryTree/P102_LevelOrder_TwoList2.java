package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树——层序遍历_双队列形式
 */
public class P102_LevelOrder_TwoList2 {

    public List<List<Integer>> levelOrder(TreeNode root){
        // 返回结果
        List<List<Integer>> res = new LinkedList<>();
        //  re1 记录当前
        List<TreeNode> re1 = new LinkedList<>();
        // re2
        List<TreeNode> re2 = new LinkedList<>();

        if (root == null) return res;

        re1.add(root);

        while ( !re1.isEmpty()){
            List<Integer> item = new LinkedList<>();

            while ( !re1.isEmpty()){
                TreeNode node = ((LinkedList<TreeNode>) re1).removeFirst();
                item.add(node.val);
                if (node.left != null){
                    re2.add(node.left);
                }
                if (node.right != null){
                    re2.add(node.right);
                }

            }
            res.add(item);

            List<TreeNode> tmp = new LinkedList<>();
            tmp = re1;
            re1 = re2;
            re2 = tmp;
        }
        return res;

    }
}

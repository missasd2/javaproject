package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P017_LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> res = new Stack<List<Integer>>();
        List<TreeNode> queue1 = new ArrayList<TreeNode>();
        List<TreeNode> queue2 = new ArrayList<TreeNode>();
        queue1.add(root);
        while(!queue1.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            while(!queue1.isEmpty()){
                TreeNode rot = queue1.remove(0);
                temp.add(rot.val);
                if(rot.left != null) queue2.add(rot.left);
                if(rot.right != null) queue2.add(rot.right);
            }
            res.push(temp);
            List<TreeNode> tmp = new ArrayList<TreeNode>();
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        while(!res.isEmpty()){
            list.add(res.pop());
        }
        return list;

    }
}

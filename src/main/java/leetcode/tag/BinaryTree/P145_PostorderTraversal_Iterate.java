package leetcode.tag.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145_PostorderTraversal_Iterate {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while ( !s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if (root.left != null){
                s1.push(root.left);
            }
            if (root.right != null){
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }


}

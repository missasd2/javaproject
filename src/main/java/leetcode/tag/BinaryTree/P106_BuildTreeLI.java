package leetcode.tag.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class P106_BuildTreeLI {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = new HashMap<Integer, Integer>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(postorder, inorder, 0, n-1, 0, n-1);
    }

    //
    public TreeNode myBuildTree(
        int[] postorder, int[] inorder, int post_left,
        int post_right, int in_left, int in_right
    )

    {
        if (post_left > post_right) return null;
        // 先得到根在后序序列中的索引
        int post_root = post_right;
        // 得到根对应在中序序列的索引
        int in_root = indexMap.get(postorder[post_root]);
        // 先把根节点建立起来
        TreeNode root = new TreeNode(inorder[in_root]);
        // 得到位于中序序列中的左子树长度
        int size_left_sub = in_root - in_left;
        // 递归建立左子树
        root.left = myBuildTree(postorder, inorder,post_left, post_left+size_left_sub-1, in_left, in_root-1);
        root.right = myBuildTree(postorder, inorder, post_left+size_left_sub, post_root-1, in_root+1, in_right);

        return root;
    }

}

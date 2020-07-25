package leetcode.tag.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * P105 从前序与中序遍历序列构造二叉树
 */
public class P105_MyBuildTree_1 {
    private Map<Integer, Integer> indexMap;
    

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<Integer, Integer>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildeTree(preorder, inorder, 0,n - 1, 0, n - 1);
    }

    public TreeNode myBuildeTree
            (int[] preorder, int[] inorder, int preorder_left, int preorder_right,
             int inorder_left, int inorder_right){
        if (preorder_left < preorder_right) return null;

        // 前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点的索引
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立起来
        TreeNode root = new TreeNode(inorder[inorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中
        root.left = myBuildeTree(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root-1);
        root.right = myBuildeTree(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root+1, inorder_right);
        return root;


    }
}

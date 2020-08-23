package leetcode.tag.BinaryTree;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 方法一：深度优先搜索
 */
public class P111_MinDepth {

    public int minDepth(TreeNode root){
        // 根节点深度为0
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    public int midDepth1(TreeNode root){
        // 根节点
        if (root == null) return 0;
        // 叶子节点
        if (root.left == null && root.right == null) return 1;

        // 左孩子，右孩子有一个为空，返回比较大的那个孩子的深度
        int m1 = midDepth1(root.left);
        int m2 = midDepth1(root.right);
        if (root.left == null || root.right == null) return m1 + m2 + 1;

        // 左右孩子都不为空，返回最小深度+1
        return Math.min(m1, m2) + 1;
    }
}

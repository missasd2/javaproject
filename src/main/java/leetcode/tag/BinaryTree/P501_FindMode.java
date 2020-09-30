package leetcode.tag.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有
 * 众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * 中序遍历，暴力法
 */
public class P501_FindMode {
    // 存储最终的众数
    List<Integer> res = new ArrayList<>();
    int count = 0; // 表示当前节点的数量
    int current = 0; // 表示当前节点的值
    int maxCount = 0; // 表示最大的重复数量

    public int[] findMode(TreeNode root){
        helper(root);
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : res){
            // 记录出现的最高频率
            map.put(i, map.getOrDefault(i, 0)+1);
            max = Math.max(max, map.get(i));
        }

        if (max > 0){
            List<Integer> num = new ArrayList<>();
            for (int b : map.keySet()){
                if (map.get(b).equals(max)){
                    num.add(b);
                }
            }

            int[] nums = new int[num.size()];
            for (int i = 0; i < nums.length; i++){
                nums[i] = num.get(i);
            }



            return nums;
        }
        return new int[0];
    }

    public void helper(TreeNode root){
        if (root == null) return ;
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }

    /**
     * 中序遍历，递归法
     */

    public int[] findMode1(TreeNode root){
        inOrderTraversal(root);

        int[] tmp = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            tmp[i] = res.get(i);
        }
        return tmp;
    }

    public void inOrderTraversal(TreeNode root){
        if (root == null) return ;
        inOrderTraversal(root.left);
        int nodeValue = root.val;
        if (nodeValue == current){
            count++;
            res.add(nodeValue);
        }else {
            current = nodeValue;
            count = 1;
        }
        if (count == maxCount){
            res.add(nodeValue);
        }else if (count > maxCount){
            res.clear();
            res.add(nodeValue);
            maxCount = count;
        }
        inOrderTraversal(root.right);
    }
}

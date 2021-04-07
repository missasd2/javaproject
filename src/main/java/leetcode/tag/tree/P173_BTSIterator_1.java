package leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

public class P173_BTSIterator_1 {
    private int idx;
    private List<Integer> arr;

    public P173_BTSIterator_1(TreeNode root){
        this.idx = 0;
        this.arr = new ArrayList<Integer>();
        inOrderTraversal(root, arr);
    }

    public Integer next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    public void inOrderTraversal(TreeNode root, List<Integer> arr){
        if (root == null) return;
        inOrderTraversal(root.left, arr);
        arr.add(root.val);
        inOrderTraversal(root.right, arr);
    }




}

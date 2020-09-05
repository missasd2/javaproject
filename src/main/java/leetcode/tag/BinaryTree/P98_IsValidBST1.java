package leetcode.tag.BinaryTree;

public class P98_IsValidBST1 implements Cloneable{


    public boolean isValisBST(TreeNode root){
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        P98_IsValidBST1 bst1 = new P98_IsValidBST1();
        Object bst2 = bst1.clone();
        System.out.println(bst1 == bst2);



    }
}

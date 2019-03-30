package offer;

/**
 * 对称的二叉树
 */
public class Solution49 {
    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot==null)return true;
        return comRoot(pRoot.left,pRoot.right);
    }

    private boolean comRoot(TreeNode left, TreeNode right) {
        if(left == null) return right==null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}

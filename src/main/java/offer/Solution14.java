package offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution14 {
    public void Mirror(TreeNode root) {
        if(root!=null){
            TreeNode tempor=root.left;
            root.left=root.right;
            root.right=tempor;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}

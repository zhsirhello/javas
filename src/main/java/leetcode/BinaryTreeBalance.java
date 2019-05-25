package leetcode;

import offer.TreeNode;

/**
 *判断一棵树是否为平衡二叉树
 * 思路：遍历节点，判断节点的左子树深度与右子树深度差是否大于1，若是大于1，直接返回false
 */
public class BinaryTreeBalance {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(height(root.left)-height(root.right))>1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //利用递归求二叉树的高度
    public int height(TreeNode root){
        if(root==null)
            return 0;
        int left=height(root.left);
        int right=height(root.right);
        if(left>right){
            return left+1;
        }
        else{
            return right+1;
        }
    }
}

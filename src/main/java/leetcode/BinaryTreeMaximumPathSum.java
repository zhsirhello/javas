package leetcode;

import offer.TreeNode;

/**
 * 二叉树，可以从任意节点开始，任意节点结束，返回这样的最大值。
 *  hard to understand
 *  可以从任意点开始，任意点结束，所以.....
 *
 */
public class BinaryTreeMaximumPathSum {
    int maxValue = 0;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        maxValue = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return maxValue;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        //因为节点的值可以为负数，所以最大值取0和子树值的较大者
        int leftMax = Math.max(0, getMaxPathSum(root.left));
        int rightMax = Math.max(0, getMaxPathSum(root.right));
        //如果将当前root作为根节点，那么最大值是root.val+左子树最大值+右子树最大值
        maxValue = Math.max(maxValue, root.val + leftMax + rightMax);
        //只能返回左右子树中较大值加上root.val
        return Math.max(0, root.val + Math.max(leftMax, rightMax));
    }
}

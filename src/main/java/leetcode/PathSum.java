package leetcode;

import offer.TreeNode;

/**
 * 给定一个二叉树和一个数，判断从根节点到叶子节点是否有和为这个数
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

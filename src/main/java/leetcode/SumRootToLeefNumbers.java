package leetcode;

import offer.TreeNode;

/**
 * 二叉树，类似从根节点开始遍历全部节点这种
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 1
 / \
 2   3
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 */
public class SumRootToLeefNumbers {
    //前序遍历思想
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        return preorderSumNumbers(root, sum);
    }
    public int preorderSumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return preorderSumNumbers(root.left, sum) + preorderSumNumbers(root.right, sum);
    }

    //回溯法
    private int sum;
    public int sumNumbers1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sum;
    }

    private void preorder(TreeNode node, StringBuilder current) {
        if (node == null) {
            return;
        }
        current.append(node.val);
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(current.toString());
        }
        preorder(node.left, current);
        preorder(node.right, current);
        current.deleteCharAt(current.length() - 1);
    }
}

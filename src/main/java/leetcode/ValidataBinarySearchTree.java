package leetcode;

import java.util.Stack;

/**
 * 判断一棵树是不是二叉搜索树
 * 采用中序遍历的思路
 */
public class ValidataBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val)
                    return false;
                pre = cur;
                cur = cur.right;
            } else {

                stack.push(cur);
                cur = cur.left;
            }
        }
        return true;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中序遍历非递归
 */
public class InorderTreeTravle {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //此处取值
            node = stack.pop();
            res.add(node.val);

            node = node.right;

        }
        return res;
    }
}

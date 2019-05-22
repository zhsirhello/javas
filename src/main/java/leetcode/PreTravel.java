package leetcode;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  前序遍历的非递归方式
 *  递归方式很容易，便不再写
 */
public class PreTravel {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(root == null)
                return list;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode temp = stack.pop();
                list.add(temp.val);
                if(temp.right != null)
                    stack.push(temp.right);
                if(temp.left != null)
                    stack.push(temp.left);
            }
            return list;
    }
}

package leetcode;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树的后序遍历，递归方法与非递归方法
 */
public class PostprderTraversal {
    //递归
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        postTraver(root);
        return list;

    }
    ArrayList<Integer> list = new ArrayList<>();
    public void postTraver(TreeNode root){
       if(root!=null){
           postTraver(root.left);
           postTraver(root.right);
           list.add(root.val);
       }
    }


    //非digui
    public ArrayList<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            // 只看栈顶元素，不弹出
            TreeNode cur = stack.peek();
            if((cur.left == null && cur.right == null)
                    || (pre != null && (pre == cur.left || pre == cur.right))){
                list.add(cur.val);
                stack.pop();
                pre = cur;
            }
            else{
                if(cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }
        return list;
    }
}

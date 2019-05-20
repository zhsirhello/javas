package leetcode;

import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求树的最小深度，递归和不递归两种方式
 */
public class MinimumDepth {
    public int run(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left==null || root.right==null){
            return Math.max(run(root.left),run(root.right))+1;
        }
        return  Math.min(run(root.left),run(root.right))+1;
    }

    public int run1(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            depth++;
            for(int i = 0; i < len; i++){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null)
                    return depth;
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return 0;
    }
}

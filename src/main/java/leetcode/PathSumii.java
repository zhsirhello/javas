package leetcode;

import offer.TreeNode;

import java.util.ArrayList;

/**
 * 给定二叉树和一个和值，找到所有路径和
 * Given the below binary tree andsum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumii {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        paths(root, sum, list);
        return res;
    }
    private void paths(TreeNode root, int sum, ArrayList<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null && sum - root.val == 0){
            list.add(root.val);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        paths(root.left, sum - root.val, list);
        paths(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}

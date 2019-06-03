package leetcode;

import java.util.ArrayList;

/**
 * 给定n，即1~n个节点组成二叉搜索树，返回不同的树
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesii {
    public ArrayList<TreeNode> generateTrees(int n) {
        return createTree(1, n);
    }
    public ArrayList<TreeNode> createTree(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if(low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i <= high; i ++) {
            // 求根结点i的左右子树集合
            ArrayList<TreeNode> left = createTree(low, i - 1);
            ArrayList<TreeNode> right = createTree(i + 1, high);
            for (int j = 0; j < left.size(); j ++) {
                for (int k = 0; k < right.size(); k ++) {
                    // 将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left.get(j);
                    newNode.right = right.get(k);
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}

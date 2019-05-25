package leetcode;

import java.util.Arrays;

/**
 * 依据中序与后续遍历建立二叉树
 */
public class ConstructBinaryFromPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0){
            return null;
        }
        int len = postorder.length;
        int temp = postorder[len-1];

        int i=0;
        for(;i<inorder.length;i++){
            if(inorder[i]==temp){
                break;
            }
        }

        int[] inorderleft = Arrays.copyOfRange(inorder, 0, i);
        int[] inorderright = Arrays.copyOfRange(inorder, i + 1, len);

        int[] postleft = Arrays.copyOfRange(postorder, 0, i);
        int[] postright = Arrays.copyOfRange(postorder, i, len - 1);

        TreeNode treeNode = new TreeNode(temp);
        treeNode.left=buildTree(inorderleft,postleft);
        treeNode.right=buildTree(inorderright,postright);

        return treeNode;
    }
}

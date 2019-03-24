package offer;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution18 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> intList=new ArrayList<Integer>();
        ArrayList<TreeNode> treeList=new ArrayList<TreeNode>();
        if(root==null){
            return intList;
        }
        treeList.add(root);
        for(int i=0;i<treeList.size();i++){
            TreeNode node=  treeList.get(i);
            if(node.left!=null){
                treeList.add(node.left);
            }
            if(node.right!=null){
                treeList.add(node.right);
            }
            intList.add(node.val);
        }
        return intList;
    }
}

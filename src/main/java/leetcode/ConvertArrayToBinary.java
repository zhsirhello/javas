package leetcode;

import java.util.Arrays;

/**
 * 有序数组，转换成平衡二叉树
 *
 */
public class ConvertArrayToBinary {
    public TreeNode sortedArrayToBST(int[] num) {
        return tempor(num);
    }

    private TreeNode tempor(int[] num){
        if(num==null||num.length==0){
            return null;
        }
        int i = num.length/2;
        TreeNode treeNode = new TreeNode(num[i]);
        treeNode.left=tempor(Arrays.copyOfRange(num,0,i));
        treeNode.right=tempor(Arrays.copyOfRange(num,i+1,num.length));
        return treeNode;
    }
}


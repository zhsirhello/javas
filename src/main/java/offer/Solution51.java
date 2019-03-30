package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution51 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot==null)return null;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(pRoot);
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        while (!stack1.empty() || !stack2.empty()){
            ArrayList<Integer> list1 = new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                list1.add(node.val);
                stack2.push(node.right);
                stack2.push(node.left);
            }
            if(list1!=null){
                lists.add(list1);
            }

            ArrayList<Integer> list2 = new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode node = stack2.pop();
                list2.add(node.val);
                stack1.push(node.right);
                stack1.push(node.left);
            }
            if(list2!=null){
                lists.add(list2);
            }
        }
        return lists;

    }
}

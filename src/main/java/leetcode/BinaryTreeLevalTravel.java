package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历思想
 */
public class BinaryTreeLevalTravel {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(root==null){
            return arrayLists;
        }
        Queue queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){
                if(queue.peek()!=null){
                    TreeNode tr = (TreeNode) queue.poll();
                    list.add(tr.val);
                    if(tr.left!=null){
                        queue.offer(tr.left);
                    }
                    if(tr.right!=null){
                        queue.offer(tr.right);
                    }
                }
            }
            arrayLists.add(list);
        }
        ArrayList<ArrayList<Integer>> arrayLists1 = new ArrayList<>();
        for(int i=arrayLists.size()-1;i>=0;i--){
            arrayLists1.add(arrayLists.get(i));
        }
        return arrayLists1;
    }
}

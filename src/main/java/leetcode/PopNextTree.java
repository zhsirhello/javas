package leetcode;

/**
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 *     做如上转换。
 *     1、可以用层序遍历的思想
 *     queue     linkedlist 的应用
 */

import java.util.LinkedList;
import java.util.Queue;

public class PopNextTree {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeLinkNode tmp = queue.poll();
                if(i == len - 1){
                    tmp.next = null;
                }else {
                    tmp.next = queue.peek();
                }
                if(tmp.left != null)
                    queue.offer(tmp.left);
                if(tmp.right != null)
                    queue.offer(tmp.right);
            }
        }
    }
}

class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

package leetcode;

/**
 * 有序链表转换成平衡二叉树。
 * 思路：在于每次找到中点作为根节点。
 *       每次都要把上次的中点去除
 */
public class ConvertListToBinary {
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        // 申请两个指针，fast移动速度是low的两倍
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);

        return root;
    }
}

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

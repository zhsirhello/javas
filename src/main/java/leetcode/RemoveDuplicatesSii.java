package leetcode;

/**
 * 删除有序链表中重复的数字，即重复的数字全部删除
 * 利用新建一个node.next=head。来避免第一个元素与后面元素相等时不通用的情况。现在即通用了
 */
public class RemoveDuplicatesSii {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode newHead = new ListNode(head.val-1);
        newHead.next = head;
        ListNode cur = head;
        ListNode last = newHead;
        while(cur!=null&&cur.next!=null){

            if(cur.val!=cur.next.val){
                last = cur;
            }else{
                while(cur.next!=null&&cur.val==cur.next.val)
                    cur = cur.next;
                last.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}

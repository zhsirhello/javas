package leetcode;

/**
 * 删除有序链表中重复的元素，保证每个元素只出现一次
 */
public class RemoveDuplicatesSortedLinked {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode head1=head;
        ListNode pre = head;
        head = head.next;
        while(head!=null){
            if(pre.val==head.val){
                head=head.next;
                pre.next=head;
            }else {
                pre = head;
                head = head.next;
            }
        }
        return head1;

    }
}

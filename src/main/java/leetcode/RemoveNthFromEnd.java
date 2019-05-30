package leetcode;

/**
 *删除链表倒数第n个节点。
 * 双指针法，只循环一次
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0;
        ListNode nitial = head;
        ListNode fast = head;
        ListNode slow=head;
        while(i<n){
            fast=fast.next;
            i++;
        }
        if(fast==null){
            return nitial.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return nitial;

    }
}

package offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution11 {
    public ListNode ReverseList(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode pre=null;
        ListNode next=null;
        while(head!=null) {
            next=head.next;//让next引用指向head下一个节点，
            head.next=pre;//pre始终指向当前head的前一个节点，这样可以反转节点了。
            pre=head;
            head=next;
        }
        return pre;
    }
}

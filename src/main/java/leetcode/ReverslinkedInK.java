package leetcode;

/**
 * 链表内翻转，每k个元素翻转一次，采用递归的方式
 * Given this linked list:1->2->3->4->5
 * For k = 2, you should return:2->1->4->3->5
 * For k = 3, you should return:3->2->1->4->5
 */
public class ReverslinkedInK {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        ListNode h=head;
        ListNode next=null,tmp=null,cur=head;
        for(int i=1;i<k;i++){
            cur=cur.next;
            if(cur==null)
                return head;
        }
        next=cur.next;
        while(head!=next){
            ListNode tmp1=head.next;
            head.next=tmp;
            tmp=head;
            head=tmp1;
        }
        h.next=reverseKGroup(next,k);
        return tmp;
    }
}

package leetcode;

/**
 * 给定链表，指定其中一段，这一段倒置。
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return1->4->3->2->5->NULL.
 *
 * 思路：（自写）一步步转换
 *          重点在于链表倒置怎么做的。这一部分已经知道！！！可参考链表重排部分代码
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
            return  head;
        }
        if(m==1){
            ListNode temp = head.next;
            ListNode head1=head;
            head.next=null;
            while(m<n){
                m++;
                ListNode t = temp.next;
                temp.next=head;
                head=temp;
                temp=t;
            }
            if(temp!=null){
                head1.next=temp;
            }
            return head;
        }
        int i=1;
        ListNode head2 = head;
        ListNode mpre=null;
        ListNode npro =null;
        while (i<m){
            if(i==m-1){
                mpre=head;
                ListNode head3=head.next;
                ListNode head1=head3;
                ListNode temp=head3.next;
                head3.next=null;
                while (m<n){
                    m++;
                    ListNode t = temp.next;
                    temp.next=head3;
                    head3=temp;
                    temp=t;
                }
                if(temp!=null){
                    head1.next=temp;
                }
                mpre.next=head3;
                return head2;
            }
            head=head.next;
            i++;
        }
        return head2;
    }
}

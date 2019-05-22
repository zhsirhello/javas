package leetcode;

/**
 * 链表重pai
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 通过快慢指针找到中间节点，拆分链表为两部分，将后半部分链表翻转，然后合并两部分
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //快慢指针找到中间节点
        ListNode slow = head, fast = head, temp = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //拆分链表为两部分
        temp = slow.next;
        slow.next = null;
        slow = temp;
        //后半边进行头插法，翻转链表
        ListNode node = slow.next;
        slow.next = null;
        while (node != null) {
            temp = node.next;
            node.next = slow;
            slow = node;
            node = temp;
        }
        //合并链表
        merge(head, slow);
    }

    public void merge(ListNode head1, ListNode head2) {
        ListNode p = head1, q = head2, temp;
        while (p != null && q != null) {
            temp = p.next;
            p.next = q;
            p = temp;
            temp = q.next;
            q.next = p;
            q = temp;
        }
    }
}

package offer;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * //只有在重复的时候next指针才需要起作用，所以有如下写法，有些难以理解，但注意是指针，指向即可。
 */
public class Solution47 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode first = new ListNode(-1,pHead);//设置一个trick
        ListNode p = pHead;
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p!= null&&p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;

    }
}

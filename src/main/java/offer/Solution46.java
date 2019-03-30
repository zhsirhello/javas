package offer;

/**
 * 链表中环的入口点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路：1、先确定是否是有环。方法为一个走两步，一个走一步，快慢相对，如果碰到结点相等，则有环。以是否为null为判断条件
 * 2、确定有环之后。设slow走了x,则fast走了2x=n+x,且n为环的长度。所以x=n。再令fast指向head，之后每走一步判断
 * fast==slow，确定入口
 */
public class Solution46 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode slow=pHead.next;
        ListNode fast=slow.next;
        while(slow!=null&&fast!=null){
            if(slow==fast){
                fast=pHead;
                break;
            }else{
                slow=slow.next;
                fast=fast.next;
                if(fast!=null){
                    fast=fast.next;
                }else return null;
            }
        }
        while (true){
            if(slow==fast){
                return fast;
            }else{
                slow=slow.next;
                fast=fast.next;
            }
        }
    }
}

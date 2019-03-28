package offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution29 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        int i=0,j=0;
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=null){
            i++;
            p1=p1.next;
        }
        while (p2!=null){
            j++;
            p2=p2.next;
        }
        if(i<j){
            i=j-i;
            while(i>0){
                pHead2=pHead2.next;
                i--;
            }
        }else{
            i=i-j;
            while(i>0){
                pHead1=pHead1.next;
                i--;
            }
        }

        while(pHead1!=null&&pHead2!=null){
            if(pHead1==pHead2)
                return pHead1;
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return null;


    }
}

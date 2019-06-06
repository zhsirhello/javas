package leetcode;

import java.util.ArrayList;

/**
 * 合并多个有序链表，归并排序思想
 */
public class MergeKsortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null||lists.size()==0){
            return null;
        }
        return mergeKList(lists,0,lists.size()-1);
    }
    public ListNode mergeKList(ArrayList<ListNode> lists,int lo,int hi){
        if (hi<=lo) return lists.get(lo);
        int mid=lo+(hi-lo)/2;
        ListNode left = mergeKList(lists,lo,mid);
        ListNode right = mergeKList(lists,mid+1,hi);
        return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right){
        ListNode h = new ListNode(-1);
        ListNode tmp=h;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                tmp.next=left;
                //tmp=tmp.next;
                left=left.next;
            }else{
                tmp.next=right;
                // tmp=tmp.next;
                right=right.next;
            } tmp=tmp.next; }
        if(left!=null){

            tmp.next=left;
        }
        if(right!=null){
            tmp.next=right;
        }
        return h.next;
    }
}

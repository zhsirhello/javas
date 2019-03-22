package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Solution3 {
    public static void main(String[] args){
        ListNode a = new ListNode(1, null);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(3, b);
        ArrayList<Integer> arr = printListFromTailToHead(c);
        System.out.println(arr.toString());
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){
            arr.add(stack.pop());
        }
        return arr;
    }
}

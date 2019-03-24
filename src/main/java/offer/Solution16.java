package offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 1、peek与pop区别在于peek获取值并不删除。那么33行为什么还要再push一次。
 */
public class Solution16 {
    // 数据栈
    Stack<Integer> dataStack = new Stack<Integer>();
    // 辅助栈
    Stack<Integer> minStack = new Stack<Integer>();
    Integer temp = null;

    // 每次压入数据栈数据与最小数据进行比较，如果更小，存入数据栈同时，存入辅助栈，并且最小值设置为该数据
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty())
        {
            minStack.push(node);
            temp = node;
        } else
        {
            temp = minStack.peek();
            if (node <= temp)
            {
                minStack.push(node);
                temp = node;
            } else
                // 依然是原来那个数更小，继续存入该最小值
                minStack.push(temp);
        }
    }

    // 数据栈出栈的同时，辅助栈也出栈，保证辅助栈的栈顶一直是最小元素
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}

package leetcode;

import java.util.Stack;

/**
 * 不懂
 */
public class LongestValidParentheses {
    public static void main(String[] ars){
        String s=")((((()()))))";
        int i = new LongestValidParentheses().longestValidParentheses(s);
        System.out.println(i);
    }
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 0)
            return 0;

        // stack中保存左括弧的index
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int last = -1;
        for(int i = 0; i < s.length(); i++){
            // 遇到左括弧就压栈
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                // 栈为空，更新起始点的位置
                if(stack.isEmpty())
                    last = i;
                else{
                    stack.pop();
                    // 更新合法括弧的长度
                    if(stack.isEmpty())
                        maxLen = Math.max(maxLen, i - last);
                    else
                        maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}

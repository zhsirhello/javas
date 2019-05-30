package leetcode;

import java.util.Stack;

/**
 *字符串为括号字符，判断格式是不是正确的。
 *
 * The brackets must close in the correct order,"()"and"()[]{}"are all valid but"(]"and"([)]"are not.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        //使用foreach循环
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

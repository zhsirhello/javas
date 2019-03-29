package offer;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 *
 * 思路，硬杠
 */
public class Solution36 {
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        if(length<=0){
            return "";
        }
        StringBuffer sb = new StringBuffer(str.substring(0, n));
        StringBuffer sb1 = new StringBuffer(str.substring(n, str.length()));
        sb1.append(sb);
        return sb1.toString();
    }
}

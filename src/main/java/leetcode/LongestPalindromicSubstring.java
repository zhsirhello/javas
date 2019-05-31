package leetcode;

/**
 * 求字符串中最长的回文字符串。
 * 思路：链接：https://www.nowcoder.com/questionTerminal/c15cd9e18e4845758d4c1086963731e2
 * 来源：牛客网
 *
 * 从回文串的对称点开始，依次向左向右比较，不相同的时候停止遍历，直到找出最大的长度的回文子串。
 * *    （1）回文子串长度为奇数：对称点只有一个字符
 * *    （2）回文子串长度为偶数：对称点有两个字符
 *
 * 上述是一种笨方法，还有如动态规划之类的考虑一下
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        //字符串的长度
        int len = s.length();
        if (len == 0) return s;
        //保留最长回文串
        String resultStr = "";
        //回文子串长度为奇数,：对称点只有一个字符的情况
        for (int i=0; i<len; ++i){
            // i 为对称点
            int left = i;//左
            int right = i;//右
            //向左向右遍历，直到发现不相同的时候停止
            while (left > 0 && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)){
                --left;
                ++right;
            }
            //比较，更新最长回文串
            if (right - left + 1 > resultStr.length()){
                resultStr = s.substring(left, right+1);
            }
        }

        //回文子串长度为偶数：对称点有两个字符
        for (int i = 0; i < len - 1; ++i){
            if (s.charAt(i) == s.charAt(i + 1)){//两个对称点相同，才有继续遍历的意义
                int left = i;
                int right = i+1;
                //向左向右遍历，直到发现不相同的时候停止
                while (left > 0 && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)){
                    --left;
                    ++right;
                }
                //比较，更新最长回文串
                if (right - left + 1 > resultStr.length()){
                    resultStr = s.substring(left, right+1);
                }
            }
        }
        return resultStr;
    }
}

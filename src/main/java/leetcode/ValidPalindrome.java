package leetcode;

/**
 * 一个字符串，里面存在字母及其它的，只需要管字符和数字，忽略大小写，判断是否是回环数
 * 以下代码：关键：如何去掉字符串中的非字母
 *          s.replaceAll("\\W", "")
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        String str = s.replaceAll("\\W", ""); // 使用正则去除非字符数字的字符
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length() - i -1)) {
                return false;
            }
        }
        return true;
    }
}

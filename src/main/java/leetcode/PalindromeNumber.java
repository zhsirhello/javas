package leetcode;

/**
 * 判断一个int类型的数字是不是回文。
 * 步转换成字符串的计算方式
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // 如果是负数，或者10的整数倍，返回false
        if (x < 0 || x != 0 && x % 10 == 0)
            return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return (reverse == x || reverse / 10 == x);
    }
}

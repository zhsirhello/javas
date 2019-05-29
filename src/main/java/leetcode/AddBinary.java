package leetcode;

/**
 * 两个二进制数相加。
 * 使用stringbuilder。非线程安全类
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            res.append(sum % 2);
            carry = sum / 2;
        }
        //res是倒序，必须进行反转
        return res.reverse().toString();
    }
}

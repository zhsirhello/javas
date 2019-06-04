package leetcode;

/**
 * 1~26对应A~Z，s为数字字符串，转换成字母字符串，问能转换成多少种不同的字符串
 * 动态规划
 *
 * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 *
 * The number of ways decoding"12"is 2.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i)))
                return 0;
        }

        // dp[i]表示s[0~i-1]可以有多少种解码方式
        // 递推方程：如果1 <= s[i-1] <= 9，则dp[i] += dp[i-1]；
        // 如果10 <= s[i-2 ~ i-1] <= 26, 则dp[i] += dp[i-2].
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i++){
            if(s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9')
                dp[i] += dp[i-1];
            if(Integer.valueOf(s.substring(i-2, i)) >= 10
                    && Integer.valueOf(s.substring(i-2, i)) <= 26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}

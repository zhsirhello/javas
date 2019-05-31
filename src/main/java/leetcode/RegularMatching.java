package leetcode;

/**
 * 正则表达式“.”和“*”匹配
 * 动态规划搞不太明白
 *
 * 动态规划
 *     如果 p[j] == str[i] || pattern[j] == '.', 此时dp[i][j] = dp[i-1][j-1];
 *     如果 p[j] == '*'
 *     分两种情况:
 *     1: 如果p[j-1] != str[i] && p[j-1] != '.', 此时dp[i][j] = dp[i][j-2] //*前面字符匹配0次
 *     2: 如果p[j-1] == str[i] || p[j-1] == '.'
 *         此时dp[i][j] = dp[i][j-2] // *前面字符匹配0次
 *         或者 dp[i][j] = dp[i][j-1] // *前面字符匹配1次
 *         或者 dp[i][j] = dp[i-1][j] // *前面字符匹配多次
 */
public class RegularMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n; i++) { // 初始化第一行，p匹配s = ""
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p[j - 1]不是"*"的情况，单字符匹配
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // p[j - 1]是"*"的情况，则要判断p[j - 2]是否匹配当前s[i - 1]
                // 若不匹配，则p[j - 1]匹配空字符串
                // 否则，有三种情况：
                //   1.p[j - 1]匹配空字符串；
                //   2.p[j - 1]匹配单一s[i - 1]字符；
                //   3.p[j - 1]匹配多个s[i - 1]字符
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}

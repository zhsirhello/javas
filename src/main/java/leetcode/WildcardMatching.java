package leetcode;

/**
 * ?和*字符匹配
 * 动态规划
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int row = s.length();
        int col = p.length();
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;
        for (int j = 1; j < col + 1; j++) {
            if (dp[0][j - 1]) {
                if (p.charAt(j - 1) == '*')
                    dp[0][j] = true;
                else
                    break;
            }
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
                }
            }

        return dp[row][col];
    }
}

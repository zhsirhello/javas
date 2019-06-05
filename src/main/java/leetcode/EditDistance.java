package leetcode;

/**
 * 把word1转换成word2，只能有增加，删除，替换三种操作，返回最少的操作数是多少
 * 动态规划
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null)
            return 0;
        if(word1 == null)
            return word2.length();
        if(word2 == null)
            return word1.length();

        // dp[i][j]代表由word1的前i个子串变为word2的前j个子串的花费
        // 其中i，j均可为0，代表空串:""
        int[][] dp = new int[word1.length() + 1][word2.length() + 2];
        dp[0][0] = 0;
        // 首先初始化两个子串中有一个为空串的情况
        for(int i = 1; i <= word1.length(); i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= word2.length(); j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                // 如果这两个字符相等，那么交由上一种情况处理,如abc，dfc
                // 这种情况与ab，df花费是一样的
                // 不然就要在删除，插入，修改中取花费最小的那个
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

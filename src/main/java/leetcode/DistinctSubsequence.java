package leetcode;

/**
 *  s有多少个子字符串等于t字符串
 *  动态规划
 *  https://www.nowcoder.com/questionTerminal/ed2923e49d3d495f8321aa46ade9f873
 *  想不明白
 */
public class DistinctSubsequence {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || T.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        int sLen = S.length();
        int tLen = T.length();
        int[][] array = new int[sLen + 1][tLen + 1];
        // 初始化第一行，字符串S为""，除了子字符串为""的情况，结果全部为0
        for (int i = 1; i < tLen + 1; i++) {
            array[0][i] = 0;
        }
        // 初始化第一列，子字符串为"",结果全部为1
        for (int i = 0; i < sLen + 1; i++) {
            array[i][0] = 1;
        }
        for (int i = 1; i < sLen + 1; i++) {
            // j>i时子序列的长度大于源数列，结果为0，无需遍历
            // 或者for (int j = 1; j <= Math.min(i, tLen); j++)
            for (int j = Math.min(i, tLen); j > 0; j--) {
                // 如果当前位置的字母不同
                if (S.charAt(i - 1) != T.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j];
                } else {// 如果当前位置的字母相同
                    array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
                }
            }

        }
        return array[sLen][tLen];
    }

    // 因为当前结果只取决于上一行结果的当前位置和后面一位，因此可以降维
    public int numDistinct2(String S, String T) {
        if (S == null || T == null || T.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        int sLen = S.length();
        int tLen = T.length();
        int[] array = new int[tLen + 1];
        array[0] = 1;
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = Math.min(i, tLen); j > 0; j--) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    array[j] = array[j] + array[j - 1];
                }
            }
        }
        return array[tLen];
    }
}

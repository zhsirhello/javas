package leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 经典之题，从递归，回溯，到动态规划都有解法
 */
public class DifferentSonSeq {
    int count = 0;
    public int numDistinct(String s, String t) {
        HashMap<String, Integer> map = new HashMap<>();
        numDistinctHelper(s, 0, t, 0, map);
        return count;
    }

    private void numDistinctHelper(String s, int s_start, String t, int t_start,
                                   HashMap<String, Integer> map) {
        if (t_start == t.length()) {
            count++;
            return;
        }
        if (s_start == s.length()) {
            return;
        }
        String key = s_start + "@" + t_start;
        if (map.containsKey(key)) {
            count += map.get(key);
            return;
        }
        int count_pre = count;
        //当前字母相等，s_start 后移一个，t_start 后移一个
        if (s.charAt(s_start) == t.charAt(t_start)) {
            numDistinctHelper(s, s_start + 1, t, t_start + 1, map);
        }
        //出来以后，继续尝试不选择当前字母，s_start 后移一个，t_start 不后移
        numDistinctHelper(s, s_start + 1, t, t_start, map);

        //将增量存起来
        int count_increment = count - count_pre;
        map.put(key, count_increment);
    }

    //动态规划
    public int numDistinct1(String s, String t){
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int i =0;i<s.length()+1 ; i++)
            dp[0][i] = 1;
        for(int i=1;i<t.length()+1;i++){
            for(int j=i;j<s.length()+1;j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];//说明S加一个字符不起作用
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}

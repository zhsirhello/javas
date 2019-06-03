package leetcode;

/**
 * 判断字符串中分割回文数最少的次数。
 * 动态规划
 *
 * 假如是abc，则至少分隔两次a,b,c
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */
public class PalindromePartioningii {

    public static int minCut(String s) {
        int[] dp = new int[s.length()];
        for(int i=0;i<s.length();i++){
            dp[i] = isPalindrome(s.substring(0, i+1))?0:i;
            if(dp[i] == 0)
                continue;
            for(int j=1;j<=i;j++){
                if(isPalindrome(s.substring(j, i+1)))
                    dp[i] = Math.min(dp[i], dp[j-1]+1);
                else
                    dp[i] = Math.min(dp[i], dp[j-1]+i+1-j);
            }
        }
        return dp[dp.length-1];
    }

    //判断回文
    public static boolean isPalindrome(String s){
        boolean flag = true;
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}

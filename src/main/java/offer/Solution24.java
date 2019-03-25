package offer;

/**
 * 整数中1出现的次数
 * 归纳法：当个位数为1时n/10 * 1+(n%10!=0 ? 1 : 0)
 * 当十位数为1时：(n / 100) * 10 + (if(k > 19) 10 else if(k < 10) 0 else k - 10 + 1)    k=n%100
 * 当百位数为1时：(n / 1000) * 100 + (if(k >199) 100 else if(k < 100) 0 else k - 100 + 1)   k=n%1000
 *
 * 最后归纳为如下程序
 */
public class Solution24 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}

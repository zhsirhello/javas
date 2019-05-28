package leetcode;

/**
 * 求开平方根
 * 根据平方数的性质——连续n个奇数相加的结果一定是平方数。
 * 如：9=1+3+5；
 * 16=1+3+5+7；
 * 所以，不断的进行奇数相加，并判断x大小即可。
 */
public class SqurtX {
    public int sqrt(int x) {
        int i = 1;
        int res = 0;
        while (x >= 0) {
            x -= i;
            res++;
            i += 2;
        }
        return res - 1;
    }
}

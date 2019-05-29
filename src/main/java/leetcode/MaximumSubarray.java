package leetcode;

/**
 * 数组中有正数有负数，求连续相加最大的值
 * 贪心算法
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if(A.length == 0) return 0;
        int sum = 0, max = A[0];
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(max < sum) max = sum;
            if(sum < 0)  sum = 0;
        }
        return max;
    }
}

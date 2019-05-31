package leetcode;

/**
 * 两个有序数组，求中位数，时间复杂度O（log（m+n））
 * 不懂
 */
public class MedianOfTwoArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        // 不论总数是奇数还是偶数，以l和r为下标的两数的均值都是medium
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;

        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    private int getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length)
            return B[bStart + k - 1];
        if (bStart >= B.length)
            return A[aStart + k - 1];
        if (k == 1)
            return Math.min(A[aStart], B[bStart]);
        int aMin = Integer.MAX_VALUE, bMin = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length)
            aMin = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length)
            bMin = B[bStart + k / 2 - 1];

        if (aMin < bMin)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);
    }
}

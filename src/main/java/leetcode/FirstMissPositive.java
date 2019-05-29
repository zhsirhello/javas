package leetcode;

/**
 * 数组中有正数负数，从1开始数，确定数组中第一个缺失的值是多少
 * 如：
 * Given[1,2,0]return3,
 * and[3,4,-1,1]return2.
 *
 * 要求时间n，空间常数项
 */
public class FirstMissPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)  // 防止越界
            return 1;
        for (int i = 0; i < A.length; i++) {
            //    A[i] - 1 < A.length 超出范围不交换    A[i] != A[A[i] - 1] 相等不交换
            while (A[i] > 0 && A[i] != i + 1 && A[i] - 1 < A.length && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            }

        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;  // 第一个不相等就返回
            }
        }
        return A[A.length - 1] + 1;  // 数组交换后是有序正数,就返回最大 + 1
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

package leetcode;

import java.util.Arrays;

/**
 * 排列问题。给定一个排列，找到按字典排序的下一个排列，如果是最大的了，则返回最小排列
 *
 * 记住是如何做的，这种，规律应该是怎样的
 * 如1，5，3，4，2
 *
 * 找到索引3，重排与交换之后为1，5，4，2，3
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num==null || num.length==0)
            return;
        //从后向前找一个位置i满足num[pos] > num[pos-1]
        int len = num.length;
        int pos = Integer.MAX_VALUE;
        for (int i=len-1; i>=1; i--) {
            if (num[i] > num[i-1]) {
                pos = i;
                break;
            }
        }
        if (pos == Integer.MAX_VALUE) {
            Arrays.sort(num);
            return ;
        }
        //从pos开始，将后面的变为升序排列
        Arrays.sort(num, pos, len);
        //从pos开始，找到第一个比num[pos-1]大的数
        for (int i=pos; i<len; i++) {
            if (num[i] > num[pos-1]) {//找到了
                //交换两个位置的元素
                int temp = num[pos-1];
                num[pos-1] = num[i];
                num[i] = temp;
                return;
            }
        }//for
    }
}

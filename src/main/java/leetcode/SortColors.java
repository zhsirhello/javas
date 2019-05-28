package leetcode;

/**
 * 数组里有0，1，2，将0排在最前，1在其中，2在其后
 * 思路：1、可以排序
 *      2、可以指定index，如果是0，则和zeroindex处元素交换，twoindex则从后往前
 */
public class SortColors {
    public void sortColors(int[] A) {
        int zeroindex = 0;
        int twoindex  = A.length - 1;
        int i = 0;
        while(i < twoindex + 1)
        {
            if(A[i] == 0)
            {
                //swap(A[i],A[zeroindex]);
                int t = A[i];
                A[i]=A[zeroindex];
                A[zeroindex]=t;
                zeroindex++;
                i++;
            }
            else if(A[i]==2)
            {
                //swap(A[i],A[twoindex]);
                int t = A[i];
                A[i]=A[twoindex];
                A[twoindex]=t;
                twoindex--;
            }
            else
                i++;
        }
    }
}

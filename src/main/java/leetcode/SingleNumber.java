package leetcode;

/**
 * 每个数字都是成对出现，只有一个数字不是，那个数字是多少。直接异或
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int num = 0;
        for(int i=0;i<A.length;i++){
            num^=A[i];
        }
        return num;
    }
}

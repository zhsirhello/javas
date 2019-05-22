package leetcode;

import java.util.Arrays;

/**
 * 给定一个数组，里面存的是权重，然后分糖果，保证相邻的权重大的比权重少的糖果多，最少一个。
 * 思路来：
 *      1、从左往右，右边大的用左边糖果数+1
 *      2、从右往左，不合规矩的
 *                         左边大的用右边糖果数+1
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) {
            return 0;
        }

        int[] count = new int[ratings.length];
        //每个孩子初始都有一个糖果
        Arrays.fill(count,1);
        int sum = 0;
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i]>ratings[i-1]) {
                count[i] = count[i-1]+1;
            }
        }

        for(int i=ratings.length-1;i>0;i--) {

            if(ratings[i]<ratings[i-1] && count[i]>=count[i-1]) {
                count[i-1] = count[i]+1;
            }
            sum+=count[i];
        }
        sum+=count[0];

        return sum;
    }
}

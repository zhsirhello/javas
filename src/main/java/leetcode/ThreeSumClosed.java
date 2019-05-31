package leetcode;

import java.util.Arrays;

/**
 * 对应3sum问题，返回的是最接近target的值
 */
public class ThreeSumClosed {

    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3)
            return 0;

        Arrays.sort(num);

        int minGap = Integer.MAX_VALUE;
        int close = 0;

        for(int i = 0; i < num.length - 2; i++){
            int l = i + 1;
            int h = num.length - 1;
            while(l < h){
                int gap = target - num[i] - num[l] - num[h];
                if(Math.abs(gap) < minGap){
                    minGap = Math.abs(gap);
                    close = num[i] + num[l] + num[h];
                }
                if(gap < 0)
                    h--;
                else if(gap > 0)
                    l++;
                else{
                    close = num[i] + num[l] + num[h];
                    return close;
                }
            }
        }
        return close;
    }
}

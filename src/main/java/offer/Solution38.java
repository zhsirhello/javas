package offer;

/**
 * 扑克牌顺子
 * 思路：
 * max 记录 最大值
 * min 记录  最小值
 * min ,max 都不记0
 * 满足条件 1 max - min <5
 *                2 除0外没有重复的数字(牌)
 *                3 数组长度 为5
 */
public class Solution38 {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length<5){
            return false;
        }
        int[]d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            if(numbers[i] == 0){
                continue;
            }
            if(d[numbers[i]]>1){
                return false;
            }
            if(numbers[i] >max){
                max = numbers[i];
            } if(numbers[i] <min){
                min = numbers[i];
            }

        }
        if(max -min<5){
            return true;
        }
        return false;
    }
}

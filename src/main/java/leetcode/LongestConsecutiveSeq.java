package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个无序数组，返回最长连续序列的长度。
 * 时间复杂度为O（n）
 * 思路：使用hashset(无重复元素)
 */
public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n : num){
            set.add(n);
        }
        int max = 1;
        for(int n : num){
            if(set.remove(n)){
                int val = n;
                int sum = 1;
                int val_small = val - 1;
                int val_big = val + 1;
                while(set.remove(val_small)){
                    sum++;
                    val_small--;
                }
                while(set.remove(val_big)){
                    val_big++;
                    sum++;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 也是求数组的全排列，但是存在重复值。
 * 回溯法
 * 首先排序，然后建一个used[] ，确定重复元素的情况，只能是前面先用的那种，因为后面先用也是一样的，他们的值是相同的。
 */
public class Permutationii {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length < 1)
            return res;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        solve(list, nums, used);

        return res;
    }
    private void solve(ArrayList<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            /*
             * 只需要判断i和i-1(而不需要判断i与i-2...) 相同的元素一定是相邻的。
             * 如果i-2，i-1，i相同，那么在上一轮循环就已经判断了i-1,i，本轮循环不需要重复判断
             */
            //此处判断，如果成立，说明相同元素前面开头已经组成过字符串了，，后面再开头没意义，直接return
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            list.add(nums[i]);
            used[i]=true;
            solve(list, nums, used);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}

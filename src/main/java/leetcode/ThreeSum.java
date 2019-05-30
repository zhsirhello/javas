package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求数组中所有三个数相加为0的组合，且以非降序的方式返回
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    // 去重复
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    // 去重复
                    while (k > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[k]);
                    result.add(item);
                    // 去重复
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}

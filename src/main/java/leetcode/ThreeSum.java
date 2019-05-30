package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求数组中所有三个数相加为0的组合，且以非降序的方式返回
 * 链接：https://www.nowcoder.com/questionTerminal/345e2ed5f81d4017bbb8cc6055b0b711
 * 来源：牛客网
 *
 * * （1）首先对数组进行排序（从小到大）
 *  * （2）依次取出第 i 个数（i从0开始），并且不重复的选取（跳过重复的数）
 *  * （3）这样问题就转换为 2 个数求和的问题（可以用双指针解决方法）
 *  *  2 数求和问题
 *  *     （4）定义两个指针：左指针（left） 和 右指针（right）
 *  *     （5）找出固定 left， 此时left所指的位置为数组中最小数，再找到两个数和 不大于 target 的最大 right 的位置
 *  *     （6）调整 left 的位置（后移），求解和是否为 target O(n)
 *  *     （7）时间复杂度：O(nlogn) + O(n)
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

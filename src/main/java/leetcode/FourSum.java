package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 四个数相加为target的组合
 * 参考了3sum的思路，双指针法，每次先取两个数，再取两个指针
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> res =new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for(int i=0;i+3<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j+2<nums.length;j++){
                if(j-1!=i&&nums[j-1]==nums[j]) continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                        ArrayList<Integer> list =new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);list.add(nums[l]);
                        res.add(new ArrayList<>(list));
                        k++;
                        l--;
                        while(k<l&&nums[k]==nums[k-1]) k++;
                        while(k<l&&nums[l]==nums[l+1]) l--;
                    }
                    else if(nums[i]+nums[j]+nums[k]+nums[l]>target)
                        l--;
                    else
                        k++;
                }
            }
        }
        return res;
    }
}

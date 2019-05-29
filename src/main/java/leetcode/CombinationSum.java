package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 求数组中和为Target的元素组合，元素可以复用。
 * 回溯法。
 */
public class CombinationSum {
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> list=new ArrayList<>();
        combination(candidates,target,list,0);
        return res;
    }
    public void combination(int[] candidates,int target,ArrayList<Integer> list,int start){
        if(target==0){res.add(new ArrayList<Integer>(list));
            return;}
        if(target<0){return;}
        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            combination(candidates,target-candidates[i],list,i);
            list.remove(list.size()-1);
        }
    }
}

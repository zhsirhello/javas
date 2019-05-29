package leetcode;

import java.util.ArrayList;

/**
 * 求一个数组的所有排列
 * 回溯法
 * 分治法怎么做？
 */
public class Permutation {
    ArrayList<ArrayList<Integer>> all =new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> one =new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int n=num.length;
        if(n==0)  return all;
        dfs(num,n);
        return all;
    }

    private void dfs(int a[],int n)
    {
        if(one.size()==n)  { all.add(new ArrayList<Integer>(one)); return;  }
        for(int i=0;i<n;i++)
        {   if(!one.contains(a[i]))
        { one.add(a[i]);
            dfs(a,n);
            one.remove(one.size()-1);
        }
        }

        return ;
    }
}

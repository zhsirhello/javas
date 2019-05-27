package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    private ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

        res = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0 || n < k)
            return res;
        generateCombinations(n, k, 1, new ArrayList<Integer>());

        return res;
    }

    public void generateCombinations(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (start > n)
            return;

        int len = k - (list.size() + 1);
        //list当中最终应该有k个元素，当前元素为list.size() + 1，那么我们要为下次回溯留下足够多的数
        for (int i = start; i <= n - len; i++) {
            list.add(i);
            generateCombinations(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

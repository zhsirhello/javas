package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 有重复元素的数组中子数组不同组合等
 * dfs。。。。
 * If S =[1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Subsetsii {
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null || num.length <= 0)
            return listAll;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);

        Findsubset(num, 0, list);

        return listAll;
    }

    public void Findsubset(int[] set, int start, ArrayList<Integer> list) {
        listAll.add(new ArrayList<>(list));

        for (int i = start; i < set.length; i++) {
            if (i > start && set[i] == set[i - 1])
                continue;
            list.add(set[i]);
            Findsubset(set, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

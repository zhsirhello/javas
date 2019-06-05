package leetcode;

import java.util.ArrayList;

/**
 * n个皇冠问题。每行每列每个对角线不允许存在两个及以上的皇冠
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 链接：https://www.nowcoder.com/questionTerminal/c77ac599d0764433a5946610a7626768
 * 来源：牛客网
 *
 * * 解题思路：
 *  * 由于需要在n*n的棋盘格中放入n个皇后，就必须每一行放一个
 *  * 否则就会出现一行有两个皇后的情况，会发生冲突。
 *  * 那么就可以递归的解决每一行问题
 *  * 最核心的问题是：如何能快速判断不合法的情况，即快速剪枝
 *  * 同行或同列的冲突可以简单用一个数组来考虑，难点是两条对角线
 *  * 对角线条数2*n-1
 *  * 左对角线：坐标x+y是一个唯一定值  x+y      范围为0到2*n-2
 *  * 右对角线：坐标x-y是一个唯一定值  x-y+n-1  范围为0到2*n-2
 */
public class NQueens {
    private ArrayList<String[]> res;

    private boolean[] col;//列
    private boolean[] dia1;//左对角线
    private boolean[] dia2;//右对角线

    public ArrayList<String[]> solveNQueens(int n) {
        res = new ArrayList<String[]>();
        if (n == 0)
            return res;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        putQueen(n, 0, new ArrayList<Integer>());
        return res;
    }

    //尝试在一个n皇后问题中，摆放第index行的皇后位置,row存放的是每一行皇后存放的下标
    private void putQueen(int n, int index, ArrayList<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            //判断能否将第index行的皇后摆放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                row.add(i);
                putQueen(n, index + 1, row);
                row.remove(row.size() - 1);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }

    private String[] generateBoard(int n, ArrayList<Integer> row) {
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == row.get(i))
                    s.append("Q");
                else
                    s.append(".");
            }
            list[i] = s.toString();
        }
        return list;
    }
}

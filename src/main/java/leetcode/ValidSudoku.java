package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个数独是否合法。
 * 即确定每一行，每一列以及每一个九宫格是否有相同的数字，如果有，则为false。
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 每一个大循环确定一行，一列，一个九宫格
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {
                // 第i行
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                // 第i列
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                //
                int cubeRow = 3 * (i / 3) + j / 3, cubeCol = 3 * (i % 3) + j % 3;
                if (board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol]))
                    return false;
            }
        }
        return true;
    }
}

package leetcode;

/**
 * 填写数独，每一行每一列的元素都不同，同时3*3小九格里的元素也都不相同
 *  简单地说思路就是循环处理子问题，对于每个格子，带入不同的9个数，
 *  *然后判合法，如果成立就递归继续，结束后把数字设回'.'
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;

        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, c, i, j)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;//递归最后一步，所有空位都填满
    }

    private boolean isValid(char[][] board, char c, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c)
                return false;
            if (board[row][i] == c)
                return false;
        }

        int xBegin = (row / 3) * 3, yBegin = (col / 3) * 3;

        for (int i = xBegin; i < xBegin + 3; i++) {
            for (int j = yBegin; j < yBegin + 3; j++) {
                if (board[i][j] == c)
                    return false;
            }
        }

        return true;
    }
}

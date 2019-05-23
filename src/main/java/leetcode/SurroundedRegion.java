package leetcode;

/**
 * Q：二维数组，有“X”与“0”两种元素，将被X包围的0转换成X
 *
 * 思路：边界点，如果为0，转换成*，之后再递归此点四周的点，如果为0，同样转换
 *       2、将所有0转换成X。所有*转换成0
 */
public class SurroundedRegion {
    public int rowNum = 0;
    public int colNum = 0;
    public void solve(char[][] board) {
        if(board == null || board.length <= 0|| board[0].length <= 0){
            return;
        }
        rowNum = board.length;
        colNum = board[0].length;
        for(int i = 0; i < colNum; i++){
            dfs(board, 0, i);
            dfs(board, rowNum-1, i);
        }
        for(int i = 0; i < rowNum; i++){
            dfs(board, i, 0);
            dfs(board, i, colNum-1);
        }
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int row, int col) {
        if(board[row][col] == 'O'){
            board[row][col] = '*';
            if(row > 1){
                dfs(board, row-1, col);
            }
            if(col > 1){
                dfs(board, row, col-1);
            }
            if(row < rowNum-1){
                dfs(board, row+1, col);
            }
            if(col < colNum-1){
                dfs(board, row, col+1);
            }
        }
    }
}

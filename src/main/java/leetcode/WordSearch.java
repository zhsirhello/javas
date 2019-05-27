package leetcode;

/**
 * 给定一个2D板和一个单词，找出该单词是否存在于网格中。
 * 该单词可以由顺序相邻的单元的字母构成，其中“相邻”单元是水平或垂直相邻的单元。 相同的字母单元格不得多次使用。
 *
 * //DFS backtracking 的算法
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, visited, i, j, m, n, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int m, int n, int count){
        if(count == word.length()){
            return true;
        }
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(count))
            return false;
        if(visited[i][j])
            return false;
        visited[i][j] = true;
        boolean res = dfs(board, word, visited, i - 1, j, m, n, count + 1) ||
                dfs(board, word, visited, i + 1, j, m, n, count + 1) ||
                dfs(board, word, visited, i, j - 1, m, n, count + 1)||
                dfs(board, word, visited, i, j + 1, m, n, count + 1);
        visited[i][j] = false;
        return res;
    }
}

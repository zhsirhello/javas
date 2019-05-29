package leetcode;

/**
 * 给定n，按环顺序形成矩阵，从1~n^2;
 * Given n =3,
 *
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 *
 */
public class SpiralMatrixii {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n < 1)
            return res;
        int index = 1, rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        while (index <= n * n) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = index++;
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                res[i][colEnd] = index++;
            }
            for (int i = colEnd - 1; i >= colStart; i--) {
                res[rowEnd][i] = index++;
            }
            for (int i = rowEnd - 1; i > rowStart; i--) {
                res[i][colStart] = index++;
            }

            rowStart += 1;
            rowEnd -= 1;
            colStart += 1;
            colEnd -= 1;

        }
        return res;
    }
}

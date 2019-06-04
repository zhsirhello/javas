package leetcode;

/**
 * 返回矩阵中1组成的最大矩形大小
 * 1、强制计算，一步一步，遍历整个矩阵，只要是1，就开始计算.....
 *
 * 还有别的方法，别的考点，太绕了，不懂
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return 0;

        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0')
                    continue;
                int width = Integer.MAX_VALUE;
                for(int p = i; p < matrix.length; p++){
                    if(matrix[p][j] == '0')
                        break;
                    for(int q = j; q < matrix[0].length; q++){
                        if(matrix[p][q] == '0' || q == matrix[0].length - 1){
                            int curwid;
                            if(matrix[p][q] == '1')
                                curwid = q - j + 1;
                            else
                                curwid = q - j;
                            if(curwid < width)
                                width = curwid;
                            int curS = width * (p - i + 1);
                            if(curS > max)
                                max = curS;
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }
}

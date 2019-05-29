package leetcode;

/**
 * 矩阵顺时针旋转90度
 *
 * 方法，先按对角线交换元素，再按x轴交换元素。
 */
public class MatrixRotation {
    public void rotate(int[][] matrix) {
       int n = matrix.length;
       //y=x对角线
       for(int i=0;i<n;i++){
           for(int j=0;j<n-i;j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[n-1-j][n-1-i];
               matrix[n-1-j][n-1-i]=temp;
           }
       }
       //y=n/2  x轴
       for(int i=0;i<n/2;i++){
           for(int j=0;j<n;j++){
               int temp = matrix[i][j];
               matrix[i][j]=matrix[n-1-i][j];
               matrix[n-1-i][j]=temp;
           }
       }
    }
}

package offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        boolean b = Find(8, arr);
        System.out.println(b);
    }
    public static boolean Find(int target, int [][] array) {
        int row = array.length;
        int coulm = array[0].length;
        int i = 0;
        int j = coulm-1;
        while(i<row&&j>=0){
            if(array[i][j]==target){
                return true;
            }else if(array[i][j]<target){
                i++;
            }else if(array[i][j]>target){
                j--;
            }
        }
        return false;
    }
}

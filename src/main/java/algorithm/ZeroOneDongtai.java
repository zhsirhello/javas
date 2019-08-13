package algorithm;

/**
 * 0-1背包问题，动态规划
 * https://blog.csdn.net/qq_38410730/article/details/81667885
 */
public class ZeroOneDongtai {
    public static void main(String[] args){
        int[] v={10,18,10};
        int[] w={2,3,2};
        int count=4;
        int l=3;
        int[][] arr = new int[l+1][count+1];
        for(int i=0;i<count;i++){
            arr[0][i]=0;
        }
        for(int i=0;i<l;i++){
            arr[i][0]=0;
        }

        for(int i=0;i<l;i++){
            for(int j=1;j<=count;j++){
                if(j<w[i]){
                    arr[i+1][j]=arr[i][j];
                }else {
                    arr[i+1][j]=Math.max(arr[i][j],arr[i][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(arr[l][count]);
    }
}

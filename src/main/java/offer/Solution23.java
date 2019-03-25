package offer;

/**
 * 连续子数组最大和
 * 方法https://blog.csdn.net/kongmin_123/article/details/82430985
 * 分析数组规律，累加法和动态规划的方法
 */
public class Solution23 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int a = array[0];
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if(a>=0)
            {
                a = a+array[i];
            }else{
                a=array[i];

            }
            if(a>max)
                max = a;
        }
        return max;
        //int max=array[0];
        //int temp=0;
        //if(array.length==1){
        //   return max;
        // }
        //for(int i=0;i<array.length-1;i++){
        //   temp=0;
        //   for(int j=i;j<array.length;j++){
        //       temp+=array[j];
        //       if(max<temp){
        //           max=temp;
        //      }
        //  }
        // }
        // return max;
    }
}

package algorithm;

/**
 *
 */
public class RankAug {
    public static void main(String[] args){
        int[] array=new int[]{2,1,8,9,5,4,7,6,3,11,16,12,15,14,13,26,23,25,24,21,22};
        quickSort(array,0,array.length-1);
        System.out.println(array.toString());
        for(int j=0;j<array.length;j++){
            System.out.println(array[j]);
        }
    }

    /**
     * 最速排序法
     * @author zhou
     * @param numbers  需要排序的数组
     * @param low       某一段下坐标
     * @param high      某一段上坐标
     */
    public static void quickSort(int[] numbers,int low,int high)
    {
        if(low < high)
        {
            int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }

    }

    /**
     * @author zhou
     * @param array
     * @param low
     * @param high
     * @return      返回数组某一段的中轴，具体意思可参考算法导论的最速排序法
     */
    public static int getMiddle(int[] array,int low,int high){
        int begin = low-1;
        int flag = array[high];
        int temp;
        for(int i=low;i<high;i++){
            if(array[i]<=flag){
                begin++;
                temp=array[begin];
                array[begin]=array[i];
                array[i]=temp;
            }
        }
        begin++;
        array[high]=array[begin];
        array[begin]=flag;
        return begin;
    }
}

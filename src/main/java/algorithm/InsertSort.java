package algorithm;

/**
 * 插入排序，从第二位开始，与前面的比较，保证前n-1位是有序的。
 * 最坏情况O(N^2)
 * 最好O(n)     做i到只与前一位比较即可
 */
public class InsertSort {

    public static void main(String[] args){
        int[] array = new int[]{2,1,8,9,5,4,7,6,3,11,16,12,15,14,13,26,23,25,24,21,22};
        sort(array);
        for(int j=0;j<array.length;j++){
            System.out.println(array[j]);
        }
    }

    //具体逻辑
    public static void sort(int[] arr){
        int tempor;
        int j;
        for(int i=1;i<arr.length;i++){
            tempor=arr[i];
            j=i-1;
            while(j>=0&&arr[j]>tempor){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=tempor;
        }
    }
}

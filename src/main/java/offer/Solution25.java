package offer;

/**
 * 数组中的逆序对。
 * 使用归并排序方法求逆序对。O（nlgn）
 */
public class Solution25 {
    public int InversePairs(int [] array) {
        return mergeSort(array,0,array.length-1);
    }
    public static int mergeSort(int arr[],int p,int r){
        if(p==r){
            return 0;
        }
        int q=(p+r)/2;
        return mergeSort(arr, p, q)+mergeSort(arr, q + 1, r)+merge(arr, p, q, r);
    }
    public static int merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        int count=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                count+=(mid-i+1);
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
        return count;
    }
}

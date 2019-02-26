package algorithm;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args){
        int[] array = new int[]{2,1,8,9,5,4,7,6,3,11,16,12,15,14,13,26,23,25,24,21,22};
        mergeSort(array,0,array.length-1);
        for(int j=0;j<array.length;j++){
            System.out.print(array[j]+",");
        }
    }

    public static void mergeSort(int arr[],int p,int r){
        if(p<r){
            int q=(p+r)/2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
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
    }
//以下代码有啥问题？
/*    public static void merge(int[] arr,int p,int q,int r){
        int n1=q-p+1;
        int n2=r-q;
        int[] arr1=new int[n1];
        int[] arr2=new int[n2];
        for(int i=0;i<n1;i++){
            arr1[i]=arr[p+i];
        }
        for(int i=0;i<n2;i++){
            arr2[i]=arr[q+i+1];
        }
        int i=0;
        int j=0;

        for(int k=p;k<=(r-p);k++){
            if(i==n1){
                arr[k]=arr2[j];
                j++;
            }else if(j==n2){
                arr[k]=arr1[i];
                i++;
            }else if(arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i++;
            }else{
                arr[k]=arr2[j];
                j++;
            }
        }
    }*/
}

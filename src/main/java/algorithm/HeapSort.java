package algorithm;

/**
 * 堆排序，最坏时间复杂度O(nlgn),期望时间复杂度O(nlgn)
 */
public class HeapSort {
    public static void main(String[] args){
        int[] array = new int[]{2,1,8,9,5,4,7,6,3,11,16,12,15,14,13,26,23,25,24,21,22};
        heapsort(array);
        for(int j=0;j<array.length;j++){
            System.out.println(array[j]);
        }

    }

    public static int parent(int i){
        return i/2;
    }
    //左子树下标
    public static int left(int i){
        return 2*(i+1)-1;
    }
    //右子树下标
    public static int right(int i){
        return left(i)+1;
    }
    //维护堆的性质
    public static void maxHeapify(int[] arr,int i,int len){
        int left=left(i);
        int right = right(i);
        int largest=0;
        if(left<len&&arr[i]<arr[left]){
            largest=left;
        }else{
            largest=i;
        }
        if(right<len&&arr[largest]<arr[right]){
            largest=right;
        }

        if(largest!=i){
            int tempor=arr[i];
            arr[i]=arr[largest];
            arr[largest]=tempor;
            maxHeapify(arr,largest,len);
        }
    }
    //建堆
    public static void buildHeapity(int[] arr){
        int len=arr.length;
        for(int i=len/2;i>=0;i--){
            maxHeapify(arr,i,arr.length);
        }
    }
    //排序
    public static void heapsort(int[] arr){
        buildHeapity(arr);
        for(int i=arr.length-1;i>0;i--){
            int tempor = arr[0];
            arr[0]=arr[i];
            arr[i]=tempor;
            maxHeapify(arr,0,i);
        }
    }
}

package offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 有序数组二分法查找
 */
public class Solution30 {
    public static void main(String[] args){
        int[] arr={1,2,3,3,3,3,4,5};
        int i = new Solution30().binaSearch(arr, 3);
        System.out.println(i);
        int i1 = new Solution30().GetNumberOfK(arr, 3);
        System.out.println(i1);
    }
    public int GetNumberOfK(int [] array , int k) {
        int flag=binaSearch(array,k);
        if(flag==-1){
            return 0;
        }else{
            int count=1;
            int flag1=flag+1;
            while(flag1>=0&&flag1<array.length){
                if(array[flag1]==k){
                    flag1++;
                    count++;
                } else break;

            }
            flag--;
            while(flag>=0&&flag<array.length){
                if(array[flag]==k){
                    count++;
                    flag--;
                }
                else break;
            }
            return count;
        }
    }

    public int binaSearch(int[] arr,int k){
        int begin=0,end=arr.length-1;
        while(begin<=end){
            int middle=begin+(end-begin)/2;
            if(arr[middle]==k)
                return middle;
            else if(arr[middle]<k)
                begin=middle+1;
            else end=middle-1;
        }
        return -1;
    }
}

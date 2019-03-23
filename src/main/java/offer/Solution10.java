package offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * ======
 * 以下是自写的一种节约空间的方式。原址
 */
public class Solution10 {
    public static void main(String[] args){
        int[] arr={1};
        reOrderArray(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void reOrderArray(int [] array) {
        int i=-1;
        int j=-1;
        int t=0;
        int temp=0;
        while(t<array.length){
            if(i!=-1&&j!=-1){
                break;
            }
            if(array[t]%2==0){
                j=t;
                t++;
            }else{
                i=t;
                t++;
            }
        }
        if(i!=-1&&j!=-1) {
            if (j < i) {
                temp = array[i];
                for (t = j; t >= 0; t--) {
                    array[t + 1] = array[t];
                }
                array[0] = temp;
                j = i;
                i = 0;
            }
            for (j = j; j < array.length; j++) {
                if (array[j] % 2 != 0) {
                    temp = array[j];
                    for (t = j - 1; t > i; t--) {
                        array[t + 1] = array[t];
                    }
                    array[++i] = temp;
                }
            }
        }
    }
}

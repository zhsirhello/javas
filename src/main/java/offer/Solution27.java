package offer;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution27 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        int[] arr = new int[index+1];
        arr[0]=1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++){
            arr[i]=Math.min(arr[t2]*2,Math.min(arr[t3]*3,arr[t5]*5));
            if(arr[i]==arr[t2]*2) t2++;
            if(arr[i]==arr[t3]*3) t3++;
            if(arr[i]==arr[t5]*5) t5++;
        }
        return arr[index-1];
    }
}

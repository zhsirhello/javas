package offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路：hashmap方法与异或法。同样的数字异或为0.所以全部数据异或，则得到两个只有一位的数字的异或和。
 * 从最低位开始，找到1，这就是他们其中一个为0一个为1却别的一位。再然后，以此为一个点，切分数组为2，
 * 再分别异或，则为对应值。
 */
public class Solution33 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
}

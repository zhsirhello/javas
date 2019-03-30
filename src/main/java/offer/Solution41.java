package offer;

/**
 * 不用加减乘除做加法
 * 两个数异或：相当于每一位相加，而不考虑进位；
 * 两个数相与，并左移一位：相当于求得进位；
 * 将上述两步的结果相加
 */
public class Solution41 {
    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}

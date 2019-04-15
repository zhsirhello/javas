package offer.other;

import java.util.Scanner;

/**
 * 求最大乘积，有负数，0，正数。两种情况，1、两个最小负数，一个最大正数  2、三个最大正数
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        long min1 = 0, min2 = 0;
        long max1 = 0, max2 = 0, max3 = 0;
        while (scanner.hasNext()) {
            long a = scanner.nextLong();
            if (a < 0) {
                if (a < min1) {
                    min2 = min1;
                    min1 = a;

                } else if (a < min2) {
                    min2 = a;
                }
            } else if (a >= 0) {
                if (a > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = a;
                } else if (a > max2) {
                    max3 = max2;
                    max2 = a;
                } else if (a > max3) {
                    max3 = a;
                }
            }
        }
        long result = max1 * max2 * max3 > min1 * min2 * max1 ? max1 * max2 * max3 : min1 * min2 * max1;
        System.out.println(result);
    }
}

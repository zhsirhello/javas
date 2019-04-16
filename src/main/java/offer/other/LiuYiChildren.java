package offer.other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 六一儿童节
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
 * 当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，
 * 使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 *
 * 贪心算法，先排序。然后从第一个孩子开始，获取巧克力，直到获取，或者巧克力都小于这个，over。
 */
public class LiuYiChildren {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// n个学生
        int[] h = new int[n];// 学生
        for (int i = 0; i < h.length; i++) {
            h[i] = sc.nextInt();
        }

        int m = sc.nextInt();// m个巧克力
        int[] w = new int[m];// 巧克力
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();
        }

        Arrays.sort(w);// 巧克力排序
        Arrays.sort(h);// 学生排序

        int stuStart = 0;
        int count = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i] < h[stuStart]) {// 如果最小的巧克力比最小的学生要的小,那么跳出去下一个巧克力
                continue;
            } else {// 如果最小的巧克力比最小的学生要的大
                count++;// 那就把这个糖果给他,count加1
                stuStart++;// 给他后,把最小的学生加一个
                if (stuStart == n) {// 如果最后一个学生都有糖了,就不找了,break掉
                    break;
                }
            }
        }
        System.out.println(count);
    }
}

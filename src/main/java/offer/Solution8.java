package offer;

import java.util.HashMap;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 类似斐波那契数列
 */
public class Solution8 {
    public static void main(String[] args){
        HashMap map=new HashMap();
        System.out.println(JumpFloor1(8));
        System.out.println(JumpFloor2(40,map));


    }
    //方法一:递归求解，耗时
    public static int JumpFloor1(int n) {
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return JumpFloor1(n-1)+JumpFloor1(n-2);

    }

    //方法二:备忘录算法
    public static int JumpFloor2(int n, HashMap<Integer,Integer> map) {
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }else{
            int value=JumpFloor2(n-1, map)+JumpFloor2(n-2, map);
            map.put(n, value);
            return value;
        }
    }
    //斐波那契方法，O（n）时间复杂度
    static int JumpFloor2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }

}

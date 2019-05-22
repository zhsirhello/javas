package leetcode;

/**
 * 给定一个整数数组，除了一个元素外，每个元素都会出现三次。 找一个单一的。
 * https://www.nowcoder.com/questionTerminal/1097ca585245418ea2efd0e8b4d9eb7a
 */
public class SingleNumberii {
    public int singleNumber(int[] A) {
        int a = 0 , b = 0;
        for(int c : A){
            int ta,tb;
            ta = a;
            tb = b;
            a = (ta&(~tb)&(~c))|((~ta)&tb&c);
            b = ~ta&((~c&tb)|(~tb&c));
        }
        return a|b;
    }
}

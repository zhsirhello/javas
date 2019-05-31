package leetcode;

/**
 * 翻转int
 * 注意：如果末位为0，
 *        或者溢出怎么处理？
 */
public class ReverseInt {
    public int reverse(int x) {
        int res=0;
        while(x!=0){
            //最后一位
            int tail=x%10;
            int newRes=res*10+tail;
            //如果newRes-tail)/10!=res说明产生了溢出
            if((newRes-tail)/10!=res)
                return 0;
            res=newRes;
            x=x/10;
        }
        return res;
    }
}

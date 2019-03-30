package offer;

/**
 * 把字符串转换成整数
 * 第一位可能表示正负，如果没有，则默认为正。不可转换情况返回0；
 * 技巧思路：从0~9的asca码为48~57。将字符串转换成字符数组
 */
public class Solution42 {
    public static void main(String[] args){
        String s="123+344";
        int i = new Solution42().StrToInt(s);
        System.out.println(i);
    }

    public int StrToInt(String str) {
        if(str.trim().equals("")){
            return 0;
        }
        char[] chars = str.toCharArray();
        int fuhao=0,sum=0,flag=0;
        if(chars[0]=='-') {
            fuhao = 1;
            flag=1;
        }
        if(chars[0]=='+'){
            flag=1;
        }
        for (int i=flag;i<chars.length;i++){
            if(chars[i]<48||chars[i]>57)
                return 0;
            sum=sum*10+chars[i]-48;
        }
        return fuhao==0?sum:sum*(-1);
    }
}

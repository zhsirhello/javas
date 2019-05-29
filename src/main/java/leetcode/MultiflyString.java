package leetcode;

/**
 * 两个字符串代表的数字相乘并以字符串返回
 * 重点，建立一个数组，然后嵌套一个个相乘
 */
public class MultiflyString {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] tmp = new int[n1+n2];

        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                tmp[i+j+1] +=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        int carrybit=0;//从个位开始，carrybit是进位
        for(int i=tmp.length-1;i>=0;i--){
            tmp[i]+=carrybit;
            carrybit=tmp[i]/10;
            tmp[i]=tmp[i]%10;

        }
        int left=0;
        while(left<tmp.length-1&&tmp[left]==0)
            left++;
        for(;left<tmp.length;left++){
            sb.append(tmp[left]);
        }
        return sb.toString();
    }

}

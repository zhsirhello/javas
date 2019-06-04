package leetcode;

import java.util.ArrayList;

/**
 * 给定代码Gray code中总位数n，打印格雷码序列
 * 格雷码是二进制数字系统，其中两个连续值仅在一位上不同。
 * For example, given n = 2, return[0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 */
public class GrayCode {
    //找规律法（洞悉本质）
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int num = 1 << n;
        for(int i = 0; i < num; ++i){
            arr.add(i>>1^i);
        }
        return arr;
    }

    //动态规划
    //链接：https://www.nowcoder.com/questionTerminal/55dddb4cdf074fefba653ff523e42346
    /*
     *规律是，后面每一个list的元素等于前面list顺序遍历的结果在每个元素前面+“0”,再逆序遍历
     *每个元素前面+"1"，可以先存储string格式方便处理，最后转换再返回int的集合
     *就可以用动态规划解决了。
     */
    public ArrayList<Integer> grayCode1(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<String> pre=new ArrayList<>();
        if(n==0) {
            list.add(0);
            return list;
        }
        pre.add("0");
        pre.add("1");
        ArrayList<String> now;
        for(int i=2;i<=n;i++) {
            now=new ArrayList<>();
            for(int j=0;j<pre.size();j++) {
                String str = "0"+pre.get(j);
                now.add(str);
            }
            for(int j=pre.size()-1;j>=0;j--) {
                String str = "1"+pre.get(j);
                now.add(str);
            }
            pre=now;
        }

        for(int i=0;i<pre.size();i++) {
            int num=getNum(pre.get(i));
            list.add(num);
        }
        return list;
    }

    public int getNum(String str) {
        char[] array=str.toCharArray();
        int i=0;
        int res=0;
        while(i<array.length) {
            if(array[i]=='1') {
                res+=Math.pow(2, array.length-1-i);
            }
            i++;
        }
        return res;
    }
}

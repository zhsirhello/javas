package leetcode;

import java.util.Set;

/**
 *给定一个字符串，然后给定一个set字符串集合，字典，问s是否可由set集合里的字符串组成
 *动态规划
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        int i,j;
        boolean array[]=new boolean[s.length()+1];//此处的Array大小
        array[0]=true;//此处的初始化
        for(i=1;i<array.length;i++) {
            for(j=0;j<i;j++) {
                if(array[j]&&dict.contains(s.substring(j, i))) {
                    array[i]=true;//此处的SubString
                    break;
                }
            }
        }
        return array[array.length-1];//此处的返回值

    }
}

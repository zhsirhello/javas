package leetcode;

import java.util.ArrayList;

/**
 * 给定一个字符串，返回所有的Ipv4可能的Ip组合
 * 深度优先搜索（DFS）
 */
public class RestoreIpAdress {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result=new ArrayList<String>(),temp=new ArrayList<String>();
        dfs(result,temp,s,0);
        return result;
    }

    public void dfs(ArrayList<String> result,ArrayList<String> temp,String s,int len) {
        if(len==s.length()&&temp.size()==4) {
            result.add(temp.get(0)+"."+temp.get(1)+"."+temp.get(2)+"."+temp.get(3));
            return;
        }
        if(s.length()-len>(4-temp.size())*3||
                s.length()-len<(4-temp.size())) return;
        for(int i=0;i<3;i++) {
            if(len+i==s.length()) break;
            int val=Integer.valueOf(s.substring(len,len+i+1));
            if(val>=0&&val<=255) {
                temp.add(s.substring(len,len+i+1));
                dfs(result,temp,s,len+i+1);
                temp.remove(temp.size()-1);
            }
            if(val==0) break;
        }
    }
}

package algorithm.maxStringInclude;

/**
 * 笨方法，一个一个试
 */
public class SelfWirte {
    public static void main(String[] args){
        String s1="qwerasdfzxcv";
        String s2="qwerzfzxcvh";
        int l=0;
        String s="";
        for(int i=0;i<s2.length();i++){
            for(int j=i+1;j<s2.length();j++){
                if(s1.contains(s2.substring(i,j))){
                    if(l<j-i){
                        l=j-i;
                        s=s2.substring(i,j);
                    }
                }

            }
        }
        System.out.println(s);
    }

}

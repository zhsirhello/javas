package leetcode;

/**
 * kmp算法
 */
public class KMP {

    public int[] getNext(String needle ){

        int j=-1;
        int i=0;
        int[] next = new int[needle.length()];
        next[i]=j;
        while(i<needle.length()-1){
            if (j==-1||needle.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(needle.charAt(i)!=needle.charAt(j)){
                    next[i]=j;
                }else{
                    next[i]=next[j];
                }

            }else{
                j=next[j];
            }
        }
        return next;
    }
    public String strStr(String haystack, String needle) {
        if(haystack==null||needle==null||needle.length()==0){
            return haystack;
        }
        if(needle.length()>haystack.length()){
            return null;
        }
        int[] next = getNext(needle);
        int i=0;
        int j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(j==-1||haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }

        }
        if(j>=needle.length()){
            return haystack.substring(i-needle.length());
        }else{
            return null;
        }
    }
}

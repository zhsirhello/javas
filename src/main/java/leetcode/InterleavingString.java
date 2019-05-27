package leetcode;

public class InterleavingString {
    public static void main(String[] args){
        System.out.println(new InterleavingString().isInterleave("a","b","ab"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        String temp=s1;
        s1=s3;
        s3=temp;
        if((s1.equals("")||s1==null)&&(s2.equals("")||s2==null)&&(s3.equals("")||s3==null)){
            return true;
        }
        if(s2.equals("")||s2==null){
            return s1.equals(s3);
        }
        if(s3.equals("")||s3==null){
            return s1.equals(s2);
        }
        if(s1.charAt(0)==s2.charAt(0)&&s1.charAt(0)==s3.charAt(0)){
            if(s2.length()==1&&s3.length()==1){
                return isInterleave(s1.substring(1),"",s3)&&isInterleave(s1.substring(1),s2,"");
            }else if(s2.length()==1&&s3.length()!=1){
                return isInterleave(s1.substring(1),"",s3)&&isInterleave(s1.substring(1),s2,s3.substring(1));
            }else if(s2.length()!=1&&s3.length()==1){
                return isInterleave(s1.substring(1),s2.substring(1),s3)&&isInterleave(s1.substring(1),s2,"");
            }else  return isInterleave(s1.substring(1),s2.substring(1),s3)&&isInterleave(s1.substring(1),s2,s3.substring(1));
        }else if(s1.charAt(0)!=s2.charAt(0)&&s1.charAt(0)==s3.charAt(0)){
            if(s3.length()==1){
                return isInterleave(s1.substring(1),s2,"");
            }else return isInterleave(s1.substring(1),s2,s3.substring(1));
        }else if(s1.charAt(0)==s2.charAt(0)&&s1.charAt(0)!=s3.charAt(0)){
            if(s2.length()==1){
                return isInterleave(s1.substring(1),"",s3);
            }else {
                return isInterleave(s1.substring(1),s2.substring(1),s3);
            }
        }else return false;
    }
}

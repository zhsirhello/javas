package algorithm.maxStringInclude;

/**
 * 求两个字符串中公共最长子字符串
 */
public class Digui {
    public static void main(String[] args){
        String s1="qwerasdfzxcv";
        String s2="qwerznfzxcvh";
        String s = iQueryMaxCommString(s1, s2);
        System.out.println(s);
    }
    public static String iQueryMaxCommString(String stringA, String stringB) {
        if(stringA==null || stringB==null){
            return null;
        }
        if(stringA.length()<1 || stringB.length()<1){
            return "";
        }
        if (stringA.contains(stringB)) {
            return stringB;
        }
        else if (stringB.length() == 1) {
            return "";
        }

        String leftSerach = iQueryMaxCommString(stringA, stringB.substring(0, stringB.length() - 1));
        String rightSerach = iQueryMaxCommString(stringA, stringB.substring(1, stringB.length()));
        return leftSerach.length() >= rightSerach.length() ? leftSerach : rightSerach;
    }


}

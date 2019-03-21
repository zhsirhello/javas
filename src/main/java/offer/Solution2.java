package offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {
    public static void main(String[] args){
        String arr = "we are family";
        String s = replaceSpace(arr);
        System.out.println(s);
    }

    public static String replaceSpace(String str) {
        if(str==null){
            return null;
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){//遇到空格
                stb.append('%');
                stb.append('2');
                stb.append('0');
            }else{
                stb.append(str.charAt(i));
            }
        }
        return stb.toString();
    }
}

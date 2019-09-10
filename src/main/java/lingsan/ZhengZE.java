package lingsan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式练习
 */
public class ZhengZE {
    public static void main(String[] args){
        replaceMy();
    }

    //正则替换
    public static void replaceMy(){
        String s="abcABC123anAA";
        //注意这里
        Pattern compile = Pattern.compile("[a-z]");
        Matcher matcher = compile.matcher(s);
        //....
        String s1 = matcher.replaceAll("");
        System.out.println(s1);
    }

}

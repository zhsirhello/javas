package lingsan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式练习
 */
public class ZhengZE {
    public static void main(String[] args){
        MacherMethodWithStartAndEnd();
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

    //捕获组
    public static void CatchGroup(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        //一个括号一个组
        //String pattern = "(\\D*)(\\d+)(.*)";
        String pattern = "([A-Za-z0-9\\s]*)(.*)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            //System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }
    //Matcher方法小用
    public static void MacherMethodWithStartAndEnd(){
        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }
}

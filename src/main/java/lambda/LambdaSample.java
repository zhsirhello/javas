package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhou
 * @describe 使用lambda.1、对list自定义排序。2、一种对list集合简化了的遍历方式
 */
public class LambdaSample {
    public static void main(String[] args){
        selfSort();
        //printConstru();
    }

    //实现对list集合的自定义排序。如下输出为（a,ab,aaa）。同时使用lambda表达式的方式实现自定义排序
    public static void selfSort(){
        List<String> list = Arrays.asList(new String[]{"ab", "a", "aaa"});
        //1
        /*Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length() - o2.length();
                if(len>=0){
                    return 1;
                }else
                    return -1;
            }
        });*/
        //2
        /*Collections.sort(list,(str1,str2)->str1.compareTo(str2));*/
        //3
        Collections.sort(list,(str1, str2)->{
            int len = str1.length() - str2.length();
            if(len>=0){
                return 1;
            }else
                return -1;

        });
        list.forEach(System.out::println);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    //语法糖？在lambda表达式部分，将全部转化成小写。特殊的输出，遍历，又是一种简化“::”双冒号表示对方法的引用
    public static void printConstru(){
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(str -> {
            return str.toLowerCase();
        }).collect(Collectors.toList());

        execStrs.forEach(System.out::println);
    }
}

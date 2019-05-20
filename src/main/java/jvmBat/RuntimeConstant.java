package jvmBat;

/**
 * jdk1.6版本后，输入true和false   p57
 * 1.6之后的版本，intern方法不会复制实例，而是在常量池中记录首次出现实例的引用
 *
 * 而java字符串已经出现过
 */
public class RuntimeConstant {
    public static void main(String[] args){
        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);

        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}

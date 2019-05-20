package dazahui;

/**
 * 关于string与interger创建返回之间的区别
 */
public class StringTest {
    public static void main(String[] art){
        String s1  = new String("hello");
        String s2 = "hello";
        System.out.println(s1==s2);     //false

        String s3 = new String("what")+new String("fuck");
        s3.intern();
        String s4 = "whatfuck";
        //s3.intern方法使用后，返回true，否则返回false
        System.out.println(s3==s4);

        intTest();
    }

    public static void intTest(){
        int i=129;
        Integer i1=i;    //相当于valueof方式创建
        int i2=i;
        Integer i3 = Integer.valueOf(i);
        Integer i4 = new Integer(i);
        System.out.println(i1==i2);  //true
        System.out.println(i1==i3);   //false    当i为127~-128时返回true
        System.out.println(i2==i3);   //true
        System.out.println(i4==i3);    //false
    }
}

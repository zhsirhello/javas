package numTread.lingsui;

import java.util.concurrent.TimeUnit;

/**
 * 关于Thread的静态方法interrupted（）与对象方法isInterrupted（）的用法以及差别
 * interrupted（）在调用中断方法之后调用第一次为true，接着会擦除这个标记，以后都是false
 * isInterrupted（）在调用中断方法之后调用为true，只有在响应中断抛出InterruptedException之后才会擦除为false
 */
public class InterruptTest {
    public static void main(String[] args){
        System.out.println(Thread.interrupted());

        Thread.currentThread().interrupt();

        //System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.interrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        }catch (InterruptedException e){
            System.out.println("已中断");
        }
        System.out.println(Thread.currentThread().isInterrupted());
    }
}

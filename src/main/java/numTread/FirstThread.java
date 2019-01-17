package numTread;

/**
 * 第一种方式，继承Thread，重写run方法。start启动
 */
public class FirstThread extends Thread{
    private int i ;
    //重写run方法，run方法的方法体就是线程执行体
    public void run()
    {
        for ( ; i < 100 ; i++ )
        {
            //当线程类继承Thread类时，可以直接调用getName()方法来返回当前线程的名。
            //如果想获取当前线程，直接使用this即可
            //Thread对象的getName返回当前该线程的名字
            System.out.println(getName() +  " " + i);
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 100;  i++)
        {
            //调用Thread的currentThread方法获取当前线程
            System.out.println(Thread.currentThread().getName() +  " " + i);
            if (i == 20)
            {
                //创建、并启动第一条线程
                new FirstThread().start();
                //创建、并启动第二条线程
                new FirstThread().start();
            }
        }
    }
}

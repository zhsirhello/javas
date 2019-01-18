package numTread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用：
 *      1、使用Executors工厂类创建线程池
 *      2、实现Runnable或者Callable接口
 *      3、submit()
 *      4、根据实际情况判断是否需要关闭池
 */
public class ThreadPool {
    public static void main(String[] args)
    {
        //创建一个具有固定线程数（6）的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        //向线程池中提交2个线程
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        //关闭线程池
        pool.shutdown();
    }
}
//实现Runnable接口来定义一个简单的
class TestThread implements Runnable
{
    public void run()
    {
        for (int i = 0; i < 100 ; i++ )
        {
            System.out.println(Thread.currentThread().getName()
                    + "的i值为:" + i);
        }
    }
}
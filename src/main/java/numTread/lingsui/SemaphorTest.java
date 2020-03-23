package numTread.lingsui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import java.util.Date;

/**
 * 实现线程的并发一秒内只能有10个的请求
 * 借用Semaphore实现
 * 过使用Semaphore信号量（Java.util.concurrent），通过对其构造函数设置一定的数量，
 * 且在使用时使用acquire()来获取相对应的信号量许可证，进而去确保一秒只能处理10个请求的效果。
 */
public class SemaphorTest {
    final static int MAX_QPS = 10;
    final static Semaphore semaphore = new Semaphore(MAX_QPS);
    public static void main(String[] args) throws InterruptedException {
        //启动一个定时执行执行任务的线程池，线程池中线程的数量为1，启动一秒后开始执行，每隔0.5秒执行一次
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            public void run() {
                semaphore.release(MAX_QPS / 2);//释放曾经被占用过的坑
            }

        }, 1000, 500, TimeUnit.MILLISECONDS);

        //创建一个有一百个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(100);
        //提交一百个线程，去执行任务
        for (int i = 100; i > 0; i--) {
            final int x = i;
            pool.submit(new Runnable() {

                public void run() {
                    for (int j = 1000; j > 0; j--) {//不断的获取被空出来的坑
                        semaphore.acquireUninterruptibly(1);//每个线程只获取一个坑
                        remoteCall(x, 0);
                    }
                }

            });
        }
        /**
         * shutdown和awaitTermination为接口ExecutorService定义的两个方法，一般情况配合使用来关闭线程池。
         方法简介
         shutdown方法：平滑的关闭ExecutorService，当此方法被调用时，ExecutorService停止接收新的任务并且等待已经提交的任务（包含提交正在执行和提交未执行）执行完成。当所有提交任务执行完毕，线程池即被关闭。

         awaitTermination方法：接收人timeout和TimeUnit两个参数，用于设定超时时间及单位。当等待超过设定时间时，会监测ExecutorService是否已经关闭，若关闭则返回true，否则返回false。一般情况下会和shutdown方法组合使用。
         ---------------------
         作者：丑胖侠
         来源：CSDN
         原文：https://blog.csdn.net/wo541075754/article/details/51564359
         版权声明：本文为博主原创文章，转载请附上博文链接！
         */
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("DONE");
    }

    private static void remoteCall(int i, int j) {
//		System.out.println(String.format("%s - %s: %d %d", new Date(),
//				Thread.currentThread(), i, j));
        System.out.println(new Date() + "   "+
                Thread.currentThread().getName() +" " +i+"  "+ j);

    }

}

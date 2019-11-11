package numTread.optimization;

import java.util.concurrent.*;

public class AbortPolicyOfThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5;
        //使用有界队列
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS,
                queue, handler);
        for(int i=0; i<100; i++) {
            try {
                executor.execute(new AbortPolicyOfThread());
            }catch (RejectedExecutionException e){
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}

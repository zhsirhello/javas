package numTread.question;

import java.util.concurrent.TimeUnit;

/**
 * 一个例子，创建一个线程组，默认优先级为10，在这个线程组之下创建一个线程，优先级默认为5，这些都不改动。
 * 然后将线程组的优先级设置为3，之后再分别打印优先级，发现线程的优先级依然为5.。。。。。。
 * 那么线程组之下的线程的优先级必须小于等于线程组的优先级不是强制的?
 *
 * 当一个线程组的优先级改变固定，后续的线程设定优先级一定小于等于线程组的。
 * 但如果先设定了线程组与线程的优先级，后面又改变了线程组的优先级，那么这个线程的优先级不会被改变，且可能比线程组的优先级大。
 */
public class GroupPriority {
    public static void main(String[] args){
        ThreadGroup mygroup = new ThreadGroup("mygroup");
       //mygroup.setMaxPriority(5);
        Thread mythread = new Thread(mygroup, () -> {
            try {
                TimeUnit.MINUTES.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "mythread");
        mythread.setPriority(8);
        mygroup.setMaxPriority(5);

        System.out.println("mythread of group is"+mythread.getThreadGroup());
        System.out.println("mythread of priority is "+mythread.getPriority());
        System.out.println("mygroup of priority us "+mygroup.getMaxPriority());
    }
}

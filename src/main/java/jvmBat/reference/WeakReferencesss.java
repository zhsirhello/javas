package jvmBat.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。
 */
public class WeakReferencesss {
    public static void main(String[] ats){
        try {
            weak();
        } catch (Exception e) {

        }
    }
    public static void weak() throws Exception
    {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        WeakReference<Object> weakRef = new WeakReference<Object>(obj, refQueue);
        System.out.println(weakRef.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        // 清除强引用,触发GC
        obj = null;
        System.gc();

        System.out.println(weakRef.get());

        // 这里特别注意:poll是非阻塞的,remove是阻塞的.
        // JVM将弱引用放入引用队列需要一定的时间,所以这里先睡眠一会儿
        // System.out.println(refQueue.poll());// 这里有可能是null

        Thread.sleep(200);
        System.out.println(refQueue.poll());
        // System.out.println(refQueue.poll());//这里一定是null,因为已经从队列中移除

        // System.out.println(refQueue.remove());
    }
}

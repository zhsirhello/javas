package jvmBat.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 软引用
 * 如果内存空间足够，垃圾回收器就不会回收它，如果内存空间不足了，就会回收这些对象的内存。
 * 软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被垃圾回收，
 * Java虚拟机就会把这个软引用加入到与之关联的引用队列中。
 */
public class SoftReferences {

    public static void main(String[] ats){
        try {
            soft();
        } catch (Exception e) {

        }
    }

    public static void soft() throws Exception
    {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        SoftReference<Object> softRef = new SoftReference<Object>(obj, refQueue);
        System.out.println(softRef.get()); // java.lang.Object@f9f9d8
        System.out.println(refQueue.poll());// null

        // 清除强引用,触发GC
        obj = null;
        System.gc();
        System.out.println(softRef.get());
        Thread.sleep(20000);
        System.out.println(refQueue.poll());
    }
}

package numTread.Lock;

public class ManyThread2 {
    public static void main(String[] args) {
        MyRunnable1 runnable1 = new MyRunnable1();
        MyRunnable2 runnable2 = new MyRunnable2();
        MyRunnable3 runnable3 = new MyRunnable3();

        Thread t1 = new Thread(runnable1, "线程1");
        Thread t2 = new Thread(runnable2, "线程2");
        Thread t3 = new Thread(runnable3, "线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Print {
    public static int count = 0;
    public static Object obj = new Object();
    public static int x = 1;

    public static void print1(int i) {
        synchronized (obj) {
            if (x == 1) {
                for (int j = 0; j < 5; j++) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ":"+ count+"____i="+i);
                }
                x = 2;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.notifyAll();
            } else {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void print2(int i) {
        synchronized (obj) {
            if (x == 2) {
                for (int j = 0; j < 5; j++) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ":"+ count+"____i="+i);
                }
                x = 3;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.notifyAll();
            } else {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void print3(int i) {
        synchronized (obj) {
            if (x == 3) {
                for (int j = 0; j < 5; j++) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ":"+ count+"____i="+i);
                }
                x = 1;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.notifyAll();
            } else {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (Print.count <= 55) {
                Print.print1(i);
            }
        }
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (Print.count <= 55) {
                Print.print2(i);
            }
        }
    }
}

class MyRunnable3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (Print.count < 50) {
                Print.print3(i);
            }
        }
    }
}

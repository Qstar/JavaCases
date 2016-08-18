package util.application;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 不要直接调用run()方法。总是调用Thread.start()方法，这个方法会创建一条新的线程并使新建的线程调用run()。
 * 参考：java.lang.Thread, java.lang.Runnable。
 */
public class ThreadOrRunnable {

    //实现Runnable的方式：
    void startAThread0() {
        new Thread(new MyRunnable()).start();
    }

    class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Runnable");
        }
    }

    //继承Thread的方式：
    void startAThread1() {
        new MyThread().start();
    }

    class MyThread extends Thread {
        public void run() {
            System.out.println("Thread");
        }
    }

    //匿名继承Thread的方式：
    void startAThread2() {
        new Thread() {
            public void run() {
                System.out.println("Anonymous");
            }
        }.start();
    }
}

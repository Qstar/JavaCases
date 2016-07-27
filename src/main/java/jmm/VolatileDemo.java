package jmm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {

    private Lock lock = new ReentrantLock();

    private int number = 0;
    //voltalie 保证可见性,不满足原子性
//    private volatile int number = 0;

    public static void main(String[] args) {
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 500; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    volatileDemo.increase();
//                }
//            }).start();

            new Thread(volatileDemo::increase).start();
        }
        while (Thread.activeCount() > 2) {
            System.out.println("线程活动数: " + Thread.activeCount());
            Thread.yield();
        }
        System.out.println("number: " + volatileDemo.getNumber());
    }

    private int getNumber() {
        return this.number;
    }

    private void increase() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        synchronized (this) {
//            this.number++;
//        }

        lock.lock();
        try {
            this.number++;
        } finally {
            lock.unlock();
        }
    }

}

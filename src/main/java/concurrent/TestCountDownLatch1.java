package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 假设我们要打印1-100，最后再输出“Ok“。1-100的打印顺序不要求统一，只需保证“Ok“是在最后出现即可。
 * 解决方案：我们定义一个CountDownLatch，然后开10个线程分别打印（n-1）*10+1至（n-1）*10+10。
 * 主线程中调用await 方法等待所有线程的执行完毕，每个线程执行完毕后都调用countDown方法。最后再await返回后打印“Ok”。
 */
public class TestCountDownLatch1 {
    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(N);
        CountDownLatch startSignal = new CountDownLatch(1);// 开始执行信号

        for (int i = 1; i <= N; i++) {
            new Thread(new Worker(i, doneSignal, startSignal)).start();// 线程启动了
        }
        System.out.println("begin------------");
        startSignal.countDown();// 开始执行啦
        doneSignal.await();// 等待所有的线程执行完毕
        System.out.println("Ok");

    }

    private static class Worker implements Runnable {
        private final CountDownLatch doneSignal;
        private final CountDownLatch startSignal;
        private int beginIndex;

        Worker(int beginIndex, CountDownLatch doneSignal,
               CountDownLatch startSignal) {
            this.startSignal = startSignal;
            this.beginIndex = beginIndex;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await(); // 等待开始执行信号的发布
                beginIndex = (beginIndex - 1) * 10 + 1;
                for (int i = beginIndex; i < beginIndex + 10; i++) {
                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                doneSignal.countDown();
            }
        }
    }
}
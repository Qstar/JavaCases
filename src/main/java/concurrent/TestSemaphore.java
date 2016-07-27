package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * A counting semaphore. Conceptually, a semaphore maintains a set of permits.
 * Each acquire() blocks if necessary until a permit is available, and then takes it.
 * Each release() adds a permit, potentially releasing a blocking acquirer.
 * However, no actual permit objects are used; the Semaphore just keeps a count of the number available and acts accordingly.
 */
public class TestSemaphore {
    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = () -> {
                try {
                    // 获取许可
                    semp.acquire();
                    System.out.println("Accessing: " + NO);
                    Thread.sleep((long) (Math.random() * 10000));
                    // 访问完后，释放
                    semp.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}


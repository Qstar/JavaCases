package designPattern.Creational.Singleton;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 单例性能测试
 */
public class TestCase {

    private static final int THREAD_COUNT = 10;
    private static final int CIRCLE_COUNT = 100000;

    @Test
    public void testSingletonPerformance() throws IOException, InterruptedException {
        final CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

        long start = System.currentTimeMillis();
        for (int i = 0; i < THREAD_COUNT; ++i) {
            new Thread(
                    () -> {
                        for (int i1 = 0; i1 < CIRCLE_COUNT; ++i1) {
                            Object instance = HungerSingleton.getInstance();
                        }
                        latch.countDown();
                    }
            ).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("HungerSingleton 共耗时: " + (end - start) + " 毫秒\n");
    }
}
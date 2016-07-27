package concurrent;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * a. Timer是基于绝对时间的。容易受系统时钟的影响。
 * b. Timer只新建了一个线程来执行所有的TimeTask。所有TimeTask可能会相关影响
 * c. Timer不会捕获TimerTask的异常，只是简单地停止。这样势必会影响其他TimeTask的执行。
 */
public class TestScheduledThreadPoolExecutor {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        // 每隔一段时间就触发异常
        exec.scheduleAtFixedRate(() -> {
            throw new RuntimeException();
        }, 1000, 5000, TimeUnit.MILLISECONDS);

        // 每隔一段时间打印系统时间，证明两者是互不影响的
        exec.scheduleAtFixedRate(() -> System.out.println(System.nanoTime()), 1000, 2000, TimeUnit.MILLISECONDS);
    }

}
package concurrent;

import java.util.concurrent.*;

/**
 * A cancellable asynchronous computation.
 * This class provides a base implementation of Future,
 * with methods to start and cancel a computation,
 * query to see if the computation is complete,
 * and retrieve the result of the computation.
 * The result can only be retrieved when the computation has completed;
 * the get methods will block if the computation has not yet completed.
 * Once the computation has completed, the computation cannot
 * be restarted or cancelled (unless the computation is invoked using runAndReset()).
 */
public class TestFutureTask {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Callable call = () -> {
            Thread.sleep(1000 * 5);
            return "Other less important but longtime things.";
        };
        Future task = exec.submit(call);
        // 重要的事情
        Thread.sleep(1000 * 3);
        System.out.println("Let’s do important things.");
        // 其他不重要的事情
        String obj = task.get().toString();
        System.out.println(obj);
        // 关闭线程池
        exec.shutdown();
    }
}


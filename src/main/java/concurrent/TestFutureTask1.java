package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 应用举例：我们的算法中有一个很耗时的操作，在编程的是，我们希望将它独立成一个模块，调用的时候当做它是立刻返回的，并且可以随时取消的
 * <p>
 * 总结：FutureTask其实就是新建了一个线程单独执行，使得线程有一个返回值，方便程序的编写
 */
public class TestFutureTask1 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        FutureTask<String> task = new FutureTask<>(
                // FutrueTask的构造参数是一个Callable接口
                () -> {
                    return Thread.currentThread().getName();// 这里可以是一个异步操作
                });

        try {
            exec.execute(task);// FutureTask实际上也是一个线程
            String result = task.get();// 取得异步计算的结果，如果没有返回，就会一直阻塞等待
            System.out.printf("get:%s%n", result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

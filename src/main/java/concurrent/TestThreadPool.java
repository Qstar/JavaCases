package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String args[]) throws InterruptedException{
        // only two threads
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int index = 0; index < 100; index++) {
            Runnable run = () -> {
                long time = (long) (Math.random() * 1000);
                System.out.println("Sleeping " + time + "ms");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(run);
        }
        // must shutdown
        exec.shutdown();
    }
}

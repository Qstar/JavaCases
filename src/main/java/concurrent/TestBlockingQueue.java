package concurrent;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A Queue that additionally supports operations that
 * wait for the queue to become non-empty when retrieving
 * an element, and wait for space to become available in the queue when storing an element.
 */
public class TestBlockingQueue {
    private static long randomTime() {
        return (long) (Math.random() * 1000);
    }

    public static void main(String[] args) {
        // 能容纳100个文件
        final BlockingQueue<File> queue = new LinkedBlockingQueue<>(100);
        // 线程池
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        final File root = new File("F:\\JavaLib");
        // 完成标志
        final File exitFile = new File("");
        // 读个数
        final AtomicInteger rc = new AtomicInteger();
        // 写个数
        final AtomicInteger wc = new AtomicInteger();
        // 读线程
        Runnable read = new Runnable() {
            public void run() {
                scanFile(root);
                scanFile(exitFile);
            }

            void scanFile(File file) {
                if (file.isDirectory()) {
                    File[] files = file.listFiles(pathname -> pathname.isDirectory()
                            || pathname.getPath().endsWith(".java"));
                    for (File one : files)
                        scanFile(one);
                } else {
                    try {
                        int index = rc.incrementAndGet();
                        System.out.println("Read0: " + index + " "
                                + file.getPath());
                        queue.put(file);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        exec.submit(read);
        // 四个写线程
        for (int index = 0; index < 4; index++) {
            // write thread
            final int NO = index;
            Runnable write = new Runnable() {
                String threadName = "Write" + NO;

                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(randomTime());
                            int index = wc.incrementAndGet();
                            File file = queue.take();
                            // 队列已经无对象
                            if (file == exitFile) {
                                // 再次添加"标志"，以让其他线程正常退出
                                queue.put(exitFile);
                                break;
                            }
                            System.out.println(threadName + ": " + index + " "
                                    + file.getPath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            exec.submit(write);
        }
        exec.shutdown();
    }
}



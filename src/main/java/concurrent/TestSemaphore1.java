package concurrent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 例如：对于某个容器，我们规定，最多只能容纳n个线程同时操作 使用信号量来模拟实现
 */
public class TestSemaphore1 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        TestSemaphore1 t = new TestSemaphore1();
        final BoundedHashSet<String> set = t.getSet();

        for (int i = 0; i < 3; i++) {// 三个线程同时操作add
            exec.execute(() -> {
                try {
                    set.add(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int j = 0; j < 3; j++) {// 三个线程同时操作remove
            exec.execute(() -> set.remove(Thread.currentThread().getName()));
        }
        exec.shutdown();
    }

    public BoundedHashSet<String> getSet() {
        return new BoundedHashSet<>(2);// 定义一个边界约束为2的线程
    }

    private class BoundedHashSet<T> {
        private final Set<T> set;
        private final Semaphore semaphore;

        BoundedHashSet(int bound) {
            this.set = Collections.synchronizedSet(new HashSet<>());//①
            this.semaphore = new Semaphore(bound, true);
        }

        public void add(T o) throws InterruptedException {
            semaphore.acquire();// 信号量控制可访问的线程数目
            set.add(o);
            System.out.printf("add:%s%n", o);
        }

        void remove(T o) {
            if (set.remove(o))
                semaphore.release();// 释放掉信号量
            System.out.printf("remove:%s%n", o);
        }
    }
}

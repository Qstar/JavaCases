package jmm;

public class SynchronizedDemo {
    //共享变量
    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        //启动线程执行写操作
        synchronizedDemo.new ReadWriteThread(true).start();
        //启动线程执行读操作
        synchronizedDemo.new ReadWriteThread(false).start();
    }

    //写操作
    public synchronized void write() {
        ready = true;
        number = 2;
    }

    //读操作
    public synchronized void read() {
        if (ready) {
            result = number * 3;
        }
        System.out.println("result的值为: " + result);
    }

    private class ReadWriteThread extends Thread {
        private boolean flag;

        ReadWriteThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                write();
            } else {
                read();
            }
        }
    }
}

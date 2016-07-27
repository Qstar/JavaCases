package Thread;

public class TestRunnable {

    public static class MyThread1 implements Runnable {
        private int ticket = 10;

        public void run() {
            for (int i = 0; i < 500; i++) {
                if (this.ticket > 0) {
                    System.out.println("卖票----->" + (this.ticket--));
                }
            }
        }
    }

    public static void main(String args[]) {
        MyThread1 mt = new MyThread1();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);
        t1.start();
        t2.start();
        t3.start();
    }

}
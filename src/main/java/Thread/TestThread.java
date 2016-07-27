package Thread;


public class TestThread {
    //一个类只要继承了Thread类，则此类就是多线程类
    public static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        //如果要使用多线程，则必须有一个方法的主体
        public void run() {
            //打印输出
            for (int i = 0; i < 10; i++) {
                System.out.println(this.name + "----->运行、、、、");
            }
        }
    }

    public static void main(String args[]) {

        //第一种方法
        Runnable r1 = new MyThread("线程A");
        Runnable r2 = new MyThread("线程B");
        Runnable r3 = new MyThread("线程C");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();

        //        mt1.run();//线程执行，使用start方法
//        mt2.run();
//        mt3.run();

        //第二种方法
//       MyThread mt1=new MyThread("线程A");
//        MyThread mt2=new MyThread("线程B");
//        MyThread mt3=new MyThread("线程C");
//        mt1.start();
//        mt1.start();//线程只能启动一次
//        mt2.start();
//        mt3.start();

    }

}
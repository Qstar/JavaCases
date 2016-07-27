package Java8.lambda;

public class ThreadExample {
    public static void main(String[] args) {
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1 Hello world !");
            }
        }).start();

        // 1.2使用 lambda expression
        new Thread(() -> System.out.println("2 Hello world !")).start();

        // 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("3 Hello world !");
            }
        };

        // 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("4 Hello world !");

        // 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();

        Runnable r1 = () -> System.out.println("r1");
        r1.run();
        new Thread(() -> System.out.println("r2")).start();
    }
}

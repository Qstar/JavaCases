package TryFinally;

/**
 * 从代码来看，貌似finally块中的println语句应该会被执行5次。
 * 但当程序运行后，你会发现finally块只执行了3次。第5次迭代的时候会触发exit函数的调用，
 * 于是这第5次的finally便永远也触发不到了。原因便是——System.exit会挂起所有线程的执行，
 * 包括当前线程。即便是try语句后的finally块，只要是执行了exit，便也无力回天了。
 * <p>
 * 在调用System.exit时，JVM会在关闭前执行两个结束任务：
 * <p>
 * 首先，它会执行完所有通过Runtime.addShutdownHook注册进来的终止的钩子程序。这一点很关键，因为它会释放JVM外部的资源。
 */
public class shutDownHooksDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                if (i == 3) {
                    System.out.println("Inside Try Block.Exiting without executing Finally block.");
                    System.exit(0);
                }
            } finally {
                System.out.println("Inside Finally Block.");
            }
        }
    }
}

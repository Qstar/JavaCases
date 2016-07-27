package TryFinally;

/**
 * 接下来的便是Finalizer了。可能是System.runFinalizersOnExit
 * 也可能是Runtime.runFinalizersOnExit。finalizer的使用已经被
 * 废弃有很长一段时间了。finalizer可以在存活对象上进行调用，即便是
 * 这些对象仍在被其它线程所使用。而这会导致不可预期的结果甚至是死锁。
 */
public class shutDownHooksDemo1 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int final_i = i;
            try {
                Runtime.getRuntime().addShutdownHook(
                        new Thread() {
                            public void run() {
                                if (final_i == 3) {
                                    System.out.println("Inside Try Block.Exiting without executing Finally block.");
                                    System.exit(0);
                                }
                            }
                        });
            } finally {
                System.out.println("Inside Finally Block.");
            }

        }
    }
}
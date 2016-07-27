package designPattern.singleton;

/**
 * 双重锁定实现
 * 问题: 适用于JDK1.5之后的版本
 */
class DoubleCheckSingleton {

    /**
     * 需要使用volatile
     * 保证所有的写(write)都将先行发生于读(read)
     */
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {                          //Single Checked
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {                  // Double Checked
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "DoubleCheckSingleton{}";
    }
}
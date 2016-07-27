package designPattern.singleton;

import java.io.Serializable;

/**
 * 懒汉式
 * 问题: 每次调用getInstance都要同步(synchronized), 效率降低
 */

/**
 * 序列化/反序列化破解单例
 * 首先对LazySingleton进行改造, 使其实现Serializable接口, 以支持序列化/反序列化.
 */
class LazySingleton implements Serializable {

    private static final long serialVersionUID = 8511876423469188139L;
    /**
     * 类加载时并没初始化, 延迟加载
     */
    private static LazySingleton instance;

    private LazySingleton() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    /**
     * 注意synchronized, 线程安全
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 反序列化时, 如果定义了readResolve方法, 则直接返回此方法制定的对象.
     *
     * @return instance
     */
    private Object readResolve() {
        return instance;
    }

    @Override
    public String toString() {
        return "LazySingleton{}";
    }
}
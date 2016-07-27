package designPattern.singleton;

/**
 * 枚举实现单例
 * 基于JVM底层实现, Enum天然的单例以及线程安全
 */
public enum EnumSingleton {
    //构造方法默认为private
    INSTANCE;

    //可以添加其他操作 other operation
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EnumSingleton{" +
                "name='" + name + '\'' +
                '}';
    }
}
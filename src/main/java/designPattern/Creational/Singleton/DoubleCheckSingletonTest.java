package designPattern.Creational.Singleton;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例破解
 * <p>
 * 可以利用Java的反射机制破解上面的单例模式(Enum是破解不了的,
 * 因为他是基于JVM底层实现的, 暂时还不知道如何破解),
 * 下面仅介绍破解双重锁定单例, 其他类同, 不再赘述.
 */
public class DoubleCheckSingletonTest {
    @Test
    public void testBreakDoubleCheck() {
        try {
            Class<DoubleCheckSingleton> clazz = (Class<DoubleCheckSingleton>) Class.forName("singleton.DoubleCheckSingleton");
            Constructor<DoubleCheckSingleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);

            DoubleCheckSingleton instance1 = constructor.newInstance();
            DoubleCheckSingleton instance2 = constructor.newInstance();
            System.out.println("singleton? " + (instance1 == instance2));
            System.out.println(instance1.hashCode());
            System.out.println(instance2.hashCode());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
package designPattern.proxy.JDKDynamicProxy;

import designPattern.proxy.JDKStaticProxy.Car;
import designPattern.proxy.JDKStaticProxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  被代理对象
     * @param method 被代理对象方法
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        method.invoke(target);
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...,汽车行驶时间: " + (endtime - starttime) + "毫秒!");
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();

        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), h);
        m.move();
    }
}

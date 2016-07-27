package Reflect;

import java.lang.reflect.Method;

public class MethodTest {
    public static void main(String[] args) {
        A a1 = new A();
        Class c = a1.getClass();

        try {
//            Method m = c.getMethod("print", new Class[]{int.class, int.class});
            Method m = c.getMethod("print", int.class, int.class);

            //方法的反射操作,用m对象进行方法掉用
//            a1.print(10,20);
//            Object o = m.invoke(a1, new Object[]{10, 20});
            Object o = m.invoke(a1, 10, 20);

            System.out.println("==========================");

            Method m1 = c.getMethod("print", String.class, String.class);
//            a1.print("hello", "WORLD");
            o = m1.invoke(a1, "hello", "WORLD");
            System.out.println("==========================");
            Method m2 = c.getMethod("print");
//            m2.invoke(a1,new Object[]{});
            m2.invoke(a1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print() {
        System.out.println("helloworld");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}
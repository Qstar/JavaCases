package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

    public static void printClassMessage(Object obj) {
        Class c = obj.getClass();
        System.out.println("类的名称是: " + c.getName());

        //getMethods包含从父类的public方法
        //getDeclaredMethods获得自己的所有方法
        Method[] ms = c.getMethods();
        for (Method m : ms) {
            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + " ");
            System.out.print(m.getName() + "(");

            Class[] paramTypes = m.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(m.getName() + ")");
        }
    }

    public static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        //            Field[] fs = c.getFields();
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    private static void printConMessage(Object obj) {
        Class c = obj.getClass();
//        Constructor[] cs = c.getConstructors();
        Constructor[] cs = c.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            System.out.print(constructor.getName() + "(");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        String s = "hello";
//        ClassUtil.printClassMessage(s);
//        ClassUtil.printFieldMessage(s);
        ClassUtil.printConMessage(s);

//        Integer n1 = 1;
//        ClassUtil.printClassMessage(n1);
    }
}

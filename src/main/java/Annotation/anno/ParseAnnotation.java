package Annotation.anno;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnnotation {
    public static void main(String[] args){
        try {
            //加载类
            Class c = Class.forName("Annotation.Child");
            //找到类上面的注解
            boolean isCExist = c.isAnnotationPresent(Description.class);
            if (isCExist) {
                //拿到注解实例
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.value());
            }

            //找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if (isMExist) {
                    Description d = m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }

            //另外一种解析方法
            for (Method m : ms) {
                Annotation[] as = m.getAnnotations();
                for (Annotation a : as) {
                    if (a instanceof Description) {
                        Description d = (Description) a;
                        System.out.printf(d.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

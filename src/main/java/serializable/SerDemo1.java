package serializable;


import java.io.*;

/**
 * 序列化一组对象
 */
public class SerDemo1 {
    public static void main(String[] args) throws Exception {
        Student[] stu = {new Student("hello", 20), new Student("world", 30),
                new Student("rollen", 40)};
        ser(stu);
        Object[] obj = dser();
        for (Object anObj : obj) {
            Student s = (Student) anObj;
            System.out.println(s);
        }
    }

    // 序列化
    private static void ser(Object[] obj) throws Exception {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                file));
        out.writeObject(obj);
        out.close();
    }

    // 反序列化
    private static Object[] dser() throws Exception {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                file));
        Object[] obj = (Object[]) input.readObject();
        input.close();
        return obj;
    }
}

class Student implements Serializable {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名： " + name + " 年龄：" + age;
    }
}
package serializable;

import java.io.*;

/**
 * 实现具有序列化能力的类
 */
class People implements Serializable {
    private String name;
    private int age;

    People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + name + " 年龄：" + age;
    }
}

/**
 * 示范ObjectOutputStream
 */
class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                file));
        oos.writeObject(new People("rollen", 20));
        oos.close();
    }
}

/**
 * * ObjectInputStream示范
 * *
 */
class ObjectInputStreamDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                file));
        Object obj = input.readObject();
        input.close();
        System.out.println(obj);
    }
}
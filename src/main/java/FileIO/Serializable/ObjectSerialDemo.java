package FileIO.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerialDemo {
    public static void main(String[] args) throws Exception{
        String file = "src/FileIO/demo/obj.dat";
        serial(file);
        unserial(file);
    }

    public static void serial(String file) throws Exception{
        //对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        Student stu = new Student("10001", "张三", 20);
        oos.writeObject(stu);
        oos.flush();
        oos.close();
    }

    private static void unserial(String file) throws Exception{
        //对象反序列化
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
        ois.close();
    }
}

package FileIO.Serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private String stuno;
    private String stuname;
    private transient int stuage;//不会进行jvm默认序列化

    public Student() {
    }

    public Student(String stuno, String stuname, int stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    //序列化
    private void writeObject(ObjectOutputStream s)
            throws IOException {
        s.defaultWriteObject();//把jvm能默认的序列化元素序列化
        s.writeInt(stuage);//自己完成transient元素的序列化
    }

    //反序列化
    private void readObject(java.io.ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();//把jvm能默认的反序列化元素反序列化
        this.stuage = s.readInt();
    }


}


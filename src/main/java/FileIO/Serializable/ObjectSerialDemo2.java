package FileIO.Serializable;

import java.io.*;

public class ObjectSerialDemo2 {
    public static void main(String[] args) throws Exception{
        String file = "src/FileIO/demo/obj1.dat";
//        serial(file);
        unserial(file);

    }

    private static void unserial(String file) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
//        Foo2 foo2 = (Foo2) ois.readObject();
//        System.out.println(foo2);
        Bar2 bar2 = (Bar2) ois.readObject();
        System.out.println(bar2);
        ois.close();
    }

    public static void serial(String file) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
//        Foo2 foo2 = new Foo2();
//        oos.writeObject(foo2);
        Bar2 bar2 = new Bar2();
        oos.writeObject(bar2);
        oos.flush();
        oos.close();
    }
}

class Foo implements Serializable {
    Foo(){
        System.out.println("foo...");
    }
}

class Foo1 extends Foo {
    Foo1(){
        System.out.println("foo1...");
    }
}

class Foo2 extends Foo1 {
    public Foo2(){
        System.out.println("foo2...");
    }
}

class Bar {
    Bar(){
        System.out.println("bar...");
    }
}

class Bar1 extends Bar implements Serializable {
    Bar1(){
        System.out.println("bar1...");
    }
}

class Bar2 extends Bar1 {
    public Bar2(){
        System.out.println("bar2...");
    }
}
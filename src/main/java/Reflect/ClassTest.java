package Reflect;

public class ClassTest {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Class c1 = Foo.class;
        Class c2 = foo.getClass();
        Class c3 = null;
        try {
            c3 = Class.forName("Reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
    }
}

class Foo {
    public void print() {
        System.out.println("Foo");
    }
}
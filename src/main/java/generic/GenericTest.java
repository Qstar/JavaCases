package generic;

public class GenericTest {

    public static void main(String[] args) {

        Box<String> name = new Box<>("corn");
        System.out.println("name:" + name.getData());

        Box<Integer> age = new Box<>(712);

        System.out.println("name class:" + name.getClass());      // generic.Box
        System.out.println("age class:" + age.getClass());        // generic.Box
        System.out.println(name.getClass() == age.getClass());    // true
    }

}

class Box<T> {

    private T data;

    public Box() {

    }

    Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
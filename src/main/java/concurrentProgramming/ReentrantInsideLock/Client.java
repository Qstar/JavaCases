package concurrentProgramming.ReentrantInsideLock;

//可重入内置锁
public class Client {
    public static void main(String[] args) {
        Child child = new Child();
        child.doSomething();
    }
}

class Father {
    public synchronized void doSomething() {
        System.out.println("Father");
    }
}

class Child extends Father {
    public synchronized void doSomething() {
        System.out.println("Child");
        super.doSomething();
    }
}
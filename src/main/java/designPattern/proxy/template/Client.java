package designPattern.proxy.template;

public class Client {
    public static void main(String[] args) {
        ProxySubject subject = new ProxySubject(new RealSubject());
        subject.operation();
    }
}

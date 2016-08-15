package designPattern.proxy.template;

public class ProxySubject extends Subject {
    private Subject realSubject;

    public ProxySubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void operation() {
        if (realSubject != null) {
            realSubject.operation();
        } else {
            //do something else
        }
    }
}
package designPattern.observer.weatherObserverJava;

public class Client {
    public static void main(String[] args) {
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();

        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("女朋友");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("妈妈");

        subject.addObserver(girl);
        subject.addObserver(mum);

        subject.setContent("天气晴朗,温度适宜");
    }
}

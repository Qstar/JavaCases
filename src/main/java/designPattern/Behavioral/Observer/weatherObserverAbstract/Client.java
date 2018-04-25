package designPattern.Behavioral.Observer.weatherObserverAbstract;

public class Client {
    public static void main(String[] args) {
        //1.创建目标
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();

        //2.创建观察者
        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("女朋友");
        girl.setRemindThing("下雨了,安静在家休息吧");

        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("妈妈");
        mum.setRemindThing("不管下雨还是下雪我都不想出门了");

        //3.注册观察者
        subject.attach(girl);
        subject.attach(mum);

        //4.目标发布天气
        subject.setWeatherContent("下雨");
        subject.setWeatherContent("下雪");
    }
}

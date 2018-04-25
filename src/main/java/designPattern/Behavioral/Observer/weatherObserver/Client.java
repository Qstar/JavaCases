package designPattern.Behavioral.Observer.weatherObserver;

public class Client {
    public static void main(String[] args) {
        //1.创建目标
        ConcreteWeatherSubject weather = new ConcreteWeatherSubject();

        //2.创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("女朋友");
        observerGirl.setRemindThing("我们不见不散");

        ConcreteObserver observerMum = new ConcreteObserver();
        observerMum.setObserverName("妈妈");
        observerMum.setRemindThing("是一个购物的好日子");

        //3.注册观察者
        weather.attach(observerGirl);
        weather.attach(observerMum);

        //4.目标发布天气信息
        weather.setWeatherContent("明天天气晴朗,蓝天白云,气温28度");
    }
}

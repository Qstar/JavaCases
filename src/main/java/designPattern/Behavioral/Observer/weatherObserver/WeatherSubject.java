package designPattern.Behavioral.Observer.weatherObserver;

import java.util.ArrayList;
import java.util.List;

//拉模型,传自身,让观察者自己取值
//推模型,知道自己需要什么值

public class WeatherSubject {
    private List<Observer> observers = new ArrayList<>();

    //添加订阅者
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //删除订阅者
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //通知更新订阅者
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}

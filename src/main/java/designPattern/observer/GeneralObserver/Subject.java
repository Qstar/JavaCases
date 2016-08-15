package designPattern.observer.GeneralObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {
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

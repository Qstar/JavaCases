package designPattern.Observer.weatherObserverAbstract;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherSubject {
    public List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected abstract void notifyObservers();

}

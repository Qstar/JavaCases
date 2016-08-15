package designPattern.observer.weatherObserverAbstract;

public interface Observer {

    void update(WeatherSubject subject);

    String getObserverName();

    void setObserverName(String observerName);
}

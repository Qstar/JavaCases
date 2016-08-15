package designPattern.observer.weatherObserverAbstract;

/**
 * Created by Qstar on 15/12/30.
 */
public class ConcreteWeatherSubject extends WeatherSubject {
    //目标对象状态
    private String weatherContent;

    @Override
    protected void notifyObservers() {
        //循环所有注册观察者
        for (Observer observer : observers) {
            if ("下雨".equals(this.getWeatherContent())) {
                if ("女朋友".equals(observer.getObserverName())) {
                    observer.update(this);
                }
                if ("妈妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }

            if ("下雪".equals(this.getWeatherContent())) {
                if ("妈妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }
        }
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }
}

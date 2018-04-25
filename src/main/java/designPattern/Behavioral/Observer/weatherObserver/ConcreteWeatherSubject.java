package designPattern.Behavioral.Observer.weatherObserver;

public class ConcreteWeatherSubject extends WeatherSubject {
    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }
}

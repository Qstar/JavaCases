package designPattern.Behavioral.Observer.weatherObserverJava;

import java.util.Observable;

public class ConcreteWeatherSubject extends Observable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();
        //主动通知,推模式
        this.notifyObservers(content);

        //拉模式
//        this.notifyObservers();
    }
}

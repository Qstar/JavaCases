package designPattern.Behavioral.Observer.GeneralObserver;

public class ConcreteObserver implements Observer {
    private String observerState;

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject) subject).getSubjectState();
    }
}

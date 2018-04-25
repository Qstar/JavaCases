package designPattern.Behavioral.Strategy;

import designPattern.Behavioral.Strategy.impl.FlyWithWin;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        super();
        super.setFlyingStrategy(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的头是红色的");
    }

}

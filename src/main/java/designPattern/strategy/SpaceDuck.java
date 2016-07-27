package designPattern.strategy;

import designPattern.strategy.impl.FlyWithRocket;

/**
 * Created by Qstar on 16/1/22.
 */
public class SpaceDuck extends Duck {
    public SpaceDuck() {
        super();
        super.setFlyingStrategy(new FlyWithRocket());
    }

    @Override
    public void display() {
        System.out.println("我头戴宇航头盔");
    }

    @Override
    public void quack() {
        System.out.println("我通过无线电与你通信");
    }
}

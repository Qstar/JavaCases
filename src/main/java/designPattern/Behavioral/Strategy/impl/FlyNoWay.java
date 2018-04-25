package designPattern.Behavioral.Strategy.impl;

import designPattern.Behavioral.Strategy.FlyingStrategy;

public class FlyNoWay implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("我不会飞行");
    }
}

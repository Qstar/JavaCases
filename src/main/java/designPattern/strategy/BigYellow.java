package designPattern.strategy;

import designPattern.strategy.impl.FlyNoWay;

public class BigYellow extends Duck {
    public BigYellow() {
        super();
        super.setFlyingStrategy(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("我身体很大,全身黄黄");
    }
}

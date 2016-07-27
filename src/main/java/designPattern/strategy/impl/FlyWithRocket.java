package designPattern.strategy.impl;

import designPattern.strategy.FlyingStrategy;

public class FlyWithRocket implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("用火箭在太空遨游");
    }
}

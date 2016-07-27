package designPattern.strategy.impl;

import designPattern.strategy.FlyingStrategy;

public class FlyWithWin implements FlyingStrategy {

    @Override
    public void performFly() {
        System.out.println("振翅高飞");
    }
}

package designPattern.strategy;

import designPattern.strategy.impl.FlyWithWin;

public class MallardDuck extends Duck {


    public MallardDuck() {
        super();
        super.setFlyingStrategy(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的脖子是绿色的");
    }

}

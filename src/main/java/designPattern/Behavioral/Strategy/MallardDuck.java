package designPattern.Behavioral.Strategy;

import designPattern.Behavioral.Strategy.impl.FlyWithWin;

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

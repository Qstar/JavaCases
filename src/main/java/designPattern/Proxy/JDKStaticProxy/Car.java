package designPattern.Proxy.JDKStaticProxy;

import java.util.Random;

public class Car implements Moveable {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Car2 extends Car {
    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        super.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...,汽车行驶时间: " + (endtime - starttime) + "毫秒!");
    }
}

class Car3 implements Moveable {
    private Car car;

    public Car3(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        car.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...,汽车行驶时间: " + (endtime - starttime) + "毫秒!");

    }
}

class client {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.move();
        //使用集成方式
//        Moveable m = new Car2();
//        m.move();
        //使用聚合方式
        Car car = new Car();
        Moveable m = new Car3(car);
        m.move();

    }
}

package designPattern.bridge;

public class Circle extends Shape{

    @Override
    public void draw() {
        color.bepaint("正方形");
    }
}
package designPattern.Structural.Bridge;

public class Circle extends Shape{

    @Override
    public void draw() {
        color.bepaint("正方形");
    }
}